package com.Trimble.Repository;


import com.Trimble.Members.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository  {

	@Autowired
	public RestTemplate restTemplate;
	//public TokenApiImpl tokenservice;

	@Value("${Trimble.entitlement.qa}")
	public String base_url;
	public Page<Member> getallMember(String trn, Pageable pageable, String token) {
		List<Member> memberlist = new ArrayList<Member>();
		String url = base_url+"/entitlements/members/activations?activationTRNs={trn}";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<Member[]> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Member[].class,
				trn);

		/*if (response.getStatusCodeValue() == 401) {
			String newToken = tokenservice.getToken();
			getallMember(trn, pageable, newToken);
		}*/

		if (response.hasBody()) {
			for (Member member : response.getBody()) {
				memberlist.add(member);
			}

		}

		final int start = (int) pageable.getOffset();
		final int end = Math.min((start + pageable.getPageSize()), memberlist.size());
		final Page<Member> list = new PageImpl<>(memberlist.subList(start, end), pageable, memberlist.size());
		return list;
	}

}
