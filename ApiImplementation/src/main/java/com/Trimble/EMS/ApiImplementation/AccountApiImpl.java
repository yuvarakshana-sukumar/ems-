package com.Trimble.EMS.ApiImplementation;

import java.util.List;

import com.Trimble.EMS.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Trimble.EMS.Entitlement.*;
import com.Trimble.EMS.RepositoryInterface.*;

@Service
public class AccountApiImpl{

	@Autowired
	public AccountRepository accountidrepository;

	public Page<Entitlement> getAllEntitlement(String customerid, String acctype, Pageable pageable, String token) {

		return accountidrepository.findall(customerid, acctype, pageable, token);

	}

}
