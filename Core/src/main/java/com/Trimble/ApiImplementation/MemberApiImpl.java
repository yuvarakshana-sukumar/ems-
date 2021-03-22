package com.Trimble.ApiImplementation;

import com.Trimble.Members.*;
import com.Trimble.Repository.MemberRepository;
import com.Trimble.RepositoryInterface.Memberrepositoryinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberApiImpl implements Memberrepositoryinterface{

	@Autowired
	public MemberRepository memberrepositoryinterface;

	@Override
	public Page<Member> getAllMember(String trn, Pageable pageable, String token) {

		return memberrepositoryinterface.getallMember(trn, pageable, token);

	}
}
