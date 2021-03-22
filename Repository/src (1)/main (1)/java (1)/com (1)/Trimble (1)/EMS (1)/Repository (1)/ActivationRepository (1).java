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

import com.Trimble.EMS.Activations.*;
import com.Trimble.EMS.RepositoryInterface.*;

@Repository
public class ActivationRepository implements Activationrepositoryinterface {

	@Autowired
	public RestTemplate restTemplate;
	public TokenRepository tokenRepository;

	@Value("${Trimble.entitlement.qa}")
	public String base_url;
	@Override
	public ActivationResult findall(String entitlementId, int page, String token) {
		String url = base_url+"/entitlements/activations?entitlementId={eId}&state=ACTIVATED&fields=intermediate&pageSize=10&pageIndex={page}";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<Activationdetails[]> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Activationdetails[].class, entitlementId, page);
		if (response.getStatusCodeValue() == 401) {
			String newToken = tokenRepository.getToken();
			findall(entitlementId, page, newToken);
		}

		List<String> total = response.getHeaders().get("Record-Count");
		int totalRecordCount = Integer.parseInt(total.get(0));
		List<Activationdetails> list = new ArrayList<Activationdetails>();
		for (Activationdetails activationdetails : response.getBody()) {
			list.add(activationdetails);

		}
		System.out.print(list);
		ActivationResult result = new ActivationResult(list, totalRecordCount);
		return result;

	}

}
