package com.Trimble.EMS.ApiImplementation;

import java.util.List;

import com.Trimble.EMS.Repository.EntitlementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Trimble.EMS.Entitlement.*;
import com.Trimble.EMS.RepositoryInterface.*;

@Service
public class EntitlementApiImpl{

	@Autowired
	public EntitlementRepository entitlementrepositoryinterface;

	public List<Entitlement> getEntitlementDetails(String eId, String token) {

		return entitlementrepositoryinterface.findall(eId, token);

	}

}
