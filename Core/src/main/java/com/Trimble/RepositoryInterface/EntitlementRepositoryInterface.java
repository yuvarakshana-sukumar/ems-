package com.Trimble.RepositoryInterface;

import com.Trimble.Entitlement.*;

import java.util.List;


public interface EntitlementRepositoryInterface {
	List<Entitlement> getEntitlementDetails(String eId, String token);

}
