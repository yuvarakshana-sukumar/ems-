package com.Trimble.Repository;

import com.Trimble.Entitlement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntitlementRepository  {

	@Autowired
	public RestTemplate restTemplate;
	//public TokenApiImpl tokenservice;
	@Value("${Trimble.entitlement.qa}")
	public String base_url;

	public List<Entitlement> findall(String eId, String token) {

		String url = base_url+"/eId";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<Entitlement[]> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Entitlement[].class, eId);
		System.out.print(response.getStatusCode());

		/*if (response.getStatusCodeValue() == 401) {
			String newToken = tokenservice.getToken();
			findall(eId, newToken);
		}*/

		List<Entitlement> list = new ArrayList<>();
		for (Entitlement entitlement : response.getBody()) {
			list.add(entitlement);
		}

		return list;

	}

}
