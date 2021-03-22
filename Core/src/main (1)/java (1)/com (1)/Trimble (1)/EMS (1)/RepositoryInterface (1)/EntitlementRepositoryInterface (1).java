package com.Trimble.EMS.RepositoryInterface;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Trimble.EMS.Entitlement.*;

@Component("entitlementrepositoryinterface")
public interface EntitlementRepositoryInterface {
	List<Entitlement> findall(String eId, String token);

}
