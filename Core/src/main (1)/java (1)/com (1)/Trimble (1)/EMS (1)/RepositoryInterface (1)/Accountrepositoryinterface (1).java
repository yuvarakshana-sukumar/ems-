package com.Trimble.EMS.RepositoryInterface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.Trimble.EMS.Entitlement.*;

@Component("accountidrepository")
public interface Accountrepositoryinterface {
	Page<Entitlement> findall(String customerid, String acctype, Pageable pageable, String token);

}
