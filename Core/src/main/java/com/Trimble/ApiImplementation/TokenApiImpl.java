package com.Trimble.ApiImplementation;

import com.Trimble.Repository.*;
import com.Trimble.RepositoryInterface.TokenRepositoryInterface;
import com.Trimble.Token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


@ComponentScan("com.Trimble.Repository")
@Service
public class TokenApiImpl implements TokenRepositoryInterface {
	@Autowired
	public TokenRepository tokenRepository;

	@Override
	public String getToken() {
		return tokenRepository.getToken();
	}

}
