package com.Trimble.EMS.RepositoryInterface;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("tokenRepository")
public interface TokenRepositoryInterface {
	String getToken();

}
