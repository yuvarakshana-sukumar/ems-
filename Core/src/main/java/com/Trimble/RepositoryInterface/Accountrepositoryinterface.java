package com.Trimble.RepositoryInterface;

import com.Trimble.Entitlement.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface Accountrepositoryinterface {
	Page<Entitlement> getAllEntitlement(String customerid, String acctype, Pageable pageable, String token);

}
