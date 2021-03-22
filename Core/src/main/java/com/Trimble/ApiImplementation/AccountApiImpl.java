package com.Trimble.ApiImplementation;

import com.Trimble.Entitlement.*;
import com.Trimble.Repository.AccountRepository;
import com.Trimble.RepositoryInterface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountApiImpl implements Accountrepositoryinterface{

	@Autowired
	public AccountRepository accountidrepository;

	@Override
	public Page<Entitlement> getAllEntitlement(String customerid, String acctype, Pageable pageable, String token) {

		return accountidrepository.findall(customerid, acctype, pageable, token);

	}

}
