package com.Trimble.RepositoryInterface;

import com.Trimble.Members.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface Memberrepositoryinterface {
	Page<Member> getAllMember(String trn, Pageable pageable, String token);

}
