package com.Trimble.EMS.ApiImplementation;

import com.Trimble.EMS.Repository.ActivationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Trimble.EMS.Activations.*;
import com.Trimble.EMS.RepositoryInterface.*;


@Service
public class ActivationApiImpl {

	@Autowired
	public ActivationRepository activationrepositoryinterface;

	public ActivationResult getAllActivation(String entitlementId, int page, String token) {

		return activationrepositoryinterface.findall(entitlementId, page, token);

	}
}
