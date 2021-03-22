package com.Trimble.EMS.ApiImplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Trimble.EMS.Repository.*;
import com.Trimble.EMS.Token.*;


@ComponentScan("com.Trimble.EMS.Repository")
@Service
public class TokenApiImpl{
	@Autowired
	public TokenRepository tokenRepository;

	public String getToken() {
		return tokenRepository.getToken();
	}

}
