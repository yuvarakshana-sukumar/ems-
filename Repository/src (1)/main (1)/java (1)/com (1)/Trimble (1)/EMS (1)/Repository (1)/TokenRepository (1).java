package com.Trimble.EMS.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.Trimble.EMS.RepositoryInterface.*;
import com.Trimble.EMS.Token.*;

@Repository
public class TokenRepository implements TokenRepositoryInterface {
	@Autowired
	public RestTemplate restTemplate;
	
	@Value("${Trimble.Token}")
	public String url;
	
	@Value("${Trimble.Token.Authorization}")
	public String authorization;

	public String getToken() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization",
				"Basic" + " " + authorization);
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<Token> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Token.class);
		Token token = new Token();
		token = response.getBody();
		return token.getAccess_token();
	}

}
