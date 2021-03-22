package com.Trimble.EMS.ApiImplementation;

import java.util.List;

import com.Trimble.EMS.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.Trimble.EMS.RepositoryInterface.Memberrepositoryinterface;
import com.Trimble.EMS.Members.*;
import com.Trimble.EMS.RepositoryInterface.*;

@Service
public class MemberApiImpl{

	@Autowired
	public MemberRepository memberrepositoryinterface;

	public Page<Member> getAllMember(String trn, Pageable pageable, String token) {

		return memberrepositoryinterface.getallMember(trn, pageable, token);

	}
}
