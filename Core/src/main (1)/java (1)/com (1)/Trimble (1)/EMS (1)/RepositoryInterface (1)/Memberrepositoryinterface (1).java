package com.Trimble.EMS.RepositoryInterface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.Trimble.EMS.Members.*;

@Component("memberrepositoryinterface")
public interface Memberrepositoryinterface {
	Page<Member> getallMember(String trn, Pageable pageable, String token);

}
