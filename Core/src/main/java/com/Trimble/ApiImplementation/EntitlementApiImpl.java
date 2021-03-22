package com.Trimble.ApiImplementation;

import com.Trimble.Entitlement.*;
import com.Trimble.Repository.EntitlementRepository;
import com.Trimble.RepositoryInterface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntitlementApiImpl implements EntitlementRepositoryInterface{

	@Autowired
	public EntitlementRepository entitlementrepositoryinterface;

	@Override
	public List<Entitlement> getEntitlementDetails(String eId, String token) {

		return entitlementrepositoryinterface.findall(eId, token);

	}

}
