package com.Trimble.EMS;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.Trimble.EMS.Activations.*;
import com.Trimble.EMS.ApiImplementation.*;
import com.Trimble.EMS.Entitlement.Entitlement;
import com.Trimble.EMS.Members.Member;

import org.springframework.web.bind.annotation.*;

@Component
@ComponentScan("com.Trimble.apiImplementation")
@RestController
public class AccountController {
	public static String token;
	public static String index = "index.jsp", account = "accountid.jsp", activation = "activation.jsp",
			entitlementdetails = "entitlementdetails.jsp", lineitemdetails = "lineitemdetails.jsp",
			activationdetails = "activationdetails.jsp", member = "member.jsp";
	@Autowired
	TokenApiImpl tokenApiImpl;

	@GetMapping("/")
	public ModelAndView homecall() {
		token = generateToken();
		ModelAndView mv = new ModelAndView();
		mv.addObject("token", token);
		mv.setViewName(index);
		return mv;
	}

	@Autowired
	AccountApiImpl accidservice;

	@GetMapping(value = "/accountid")
	public ModelAndView form1(HttpServletRequest req, HttpServletResponse res) {
		int page = 1;
		String customerid = req.getParameter("accid");
		String acctype = req.getParameter("acctype");
		return pagination(customerid, acctype, page);

	}

	@GetMapping("/account")
	public ModelAndView accountcall(HttpServletRequest req, HttpServletResponse res, @RequestParam String customerid,
			@RequestParam String acctype, @RequestParam int page) {
		return pagination(customerid, acctype, page);
	}

	@GetMapping("/entitlementdetails")
	public ModelAndView entitlementdetailscall(HttpServletRequest req, HttpServletResponse res,
			@RequestParam String entitlementId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("eId", entitlementId);
		mv.setViewName(entitlementdetails);
		return mv;
	}

	@Autowired
	EntitlementApiImpl eidservice;

	@GetMapping("/entitlementdetail")
	public ModelAndView entitlementdetailcall(HttpServletRequest req, HttpServletResponse res) {
		String eId = req.getParameter("eid");
		List<Entitlement> list = eidservice.getEntitlementDetails(eId, token);
		ModelAndView mv = new ModelAndView();
		mv.addObject("eId", eId);
		mv.addObject("entitlement", list);
		mv.setViewName(entitlementdetails);
		return mv;
	}

	@GetMapping("/lineitemdetails")
	public ModelAndView lineitemdetailscall(HttpServletRequest req, HttpServletResponse res,
			@RequestParam String lineitemId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("lId", lineitemId);
		mv.setViewName(lineitemdetails);
		return mv;
	}

	@Autowired
	ActivationApiImpl activationservice;

	@GetMapping("/activation")
	public ModelAndView activationcall(HttpServletRequest req, HttpServletResponse res,
			@RequestParam String entitlementId) {

		return activationPagination(entitlementId, 1);
	}

	@GetMapping("/activations")
	public ModelAndView activationscall(HttpServletRequest req, HttpServletResponse res,
			@RequestParam String entitlementId, @RequestParam int page) {
		return activationPagination(entitlementId, page);
	}

	@GetMapping("/activationdetails")
	public ModelAndView activationdetailscall(HttpServletRequest req, HttpServletResponse res,
			@RequestParam String activationId, @RequestParam String trn) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("aId", activationId);
		mv.addObject("trn", trn);
		mv.setViewName(activationdetails);
		return mv;
	}

	@Autowired
	MemberApiImpl memberservice;

	@GetMapping("/member")
	public ModelAndView membercall(HttpServletRequest req, HttpServletResponse res, @RequestParam String trn) {
		return memberPagination(trn, 1);
	}

	@GetMapping("/members")
	public ModelAndView memberscall(HttpServletRequest req, HttpServletResponse res, @RequestParam String trn,
			@RequestParam int page) {
		return memberPagination(trn, page);
	}

	public ModelAndView pagination(String customerid, String acctype, int page) {
		Pageable pageable = PageRequest.of(page - 1, 10);
		Page<Entitlement> entitlementlist = accidservice.getAllEntitlement(customerid, acctype, pageable, token);
		List<Entitlement> list = new ArrayList<>();
		list = entitlementlist.toList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("entitlement", list);
		mv.addObject("customerid", customerid);
		mv.addObject("acctype", acctype);
		mv.addObject("currentPage", page);
		mv.addObject("totalPages", entitlementlist.getTotalPages());
		mv.setViewName(account);
		return mv;

	}

	public ModelAndView activationPagination(String entitlementId, int page) {
		List<Activationdetails> list = new ArrayList<Activationdetails>();
		ActivationResult result = activationservice.getAllActivation(entitlementId, page, token);
		list = result.getList();
		int totalRecordCount = result.getTotalRecordCount();
		int totalPages = (int) (Math.ceil((double) totalRecordCount / 10.0));
		ModelAndView mv = new ModelAndView();
		mv.addObject("activation", list);
		mv.addObject("totalPages", totalPages);
		mv.addObject("eid", entitlementId);
		mv.setViewName(activation);
		return mv;

	}

	public ModelAndView memberPagination(String trn, int page) {
		Pageable pageable = PageRequest.of(page - 1, 10);
		Page<Member> memberlist = memberservice.getAllMember(trn, pageable, token);
		List<Member> list = new ArrayList<>();
		list = memberlist.toList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", list);
		mv.addObject("trn", trn);
		mv.addObject("totalPages", memberlist.getTotalPages());
		mv.setViewName(member);
		return mv;

	}

	public String generateToken() {
		return tokenApiImpl.getToken();
	}

}
