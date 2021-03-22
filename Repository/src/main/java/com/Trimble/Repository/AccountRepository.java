package com.Trimble.Repository;

import com.Trimble.Entitlement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component("accountidrepository")
@Repository
public class AccountRepository  {

	@Autowired
	public RestTemplate restTemplate;
	//public TokenApiImpl tokenservice;

	@Value("${Trimble.entitlement.qa}")
	public String base_url;
	public Page<Entitlement> findall(String customerid, String acctype, Pageable pageable, String token) {

		System.out.print(token);

		String url = base_url+"/entitlements?accountId={customerid}&accountType={acctype}&entitlementState=COMMITTED&fields=detail";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<Entitlement[]> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Entitlement[].class, customerid, acctype);

		/*if (response.getStatusCodeValue() == 401) {
			String newToken = tokenservice.getToken();
			findall(customerid, acctype, pageable, newToken);
		}*/

		List<Entitlement> entitlementlist = new ArrayList<>();
		for (Entitlement entitlement : response.getBody()) {
			entitlementlist.add(entitlement);
		}
		final int start = (int) pageable.getOffset();
		final int end = Math.min((start + pageable.getPageSize()), entitlementlist.size());
		final Page<Entitlement> list = new PageImpl<>(entitlementlist.subList(start, end), pageable,
				entitlementlist.size());
		return list;

	}

}
