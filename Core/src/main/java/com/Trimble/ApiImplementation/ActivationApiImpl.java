package com.Trimble.ApiImplementation;

import com.Trimble.Activations.*;
import com.Trimble.Repository.ActivationRepository;
import com.Trimble.RepositoryInterface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ActivationApiImpl implements Activationrepositoryinterface{

	@Autowired
	public ActivationRepository activationrepositoryinterface;

	@Override
	public ActivationResult getAllActivation(String entitlementId, int page, String token) {

		return activationrepositoryinterface.findall(entitlementId, page, token);

	}
}
