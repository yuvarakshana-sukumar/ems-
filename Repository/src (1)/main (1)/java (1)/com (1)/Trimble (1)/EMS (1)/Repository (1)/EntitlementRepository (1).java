package com.Trimble.EMS.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


import com.Trimble.EMS.Entitlement.*;
import com.Trimble.EMS.RepositoryInterface.*;

@Repository
public class EntitlementRepository implements EntitlementRepositoryInterface {

	@Autowired
	public RestTemplate restTemplate;
	public TokenRepository tokenRepository;
	@Value("${Trimble.entitlement.qa}")
	public String base_url;

	@Override
	public List<Entitlement> findall(String eId, String token) {

		String url = base_url+"/eId";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<Entitlement[]> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Entitlement[].class, eId);
		System.out.print(response.getStatusCode());

		if (response.getStatusCodeValue() == 401) {
			String newToken = tokenRepository.getToken();
			findall(eId, newToken);
		}

		List<Entitlement> list = new ArrayList<>();
		for (Entitlement entitlement : response.getBody()) {
			list.add(entitlement);
		}

		return list;

	}

}
