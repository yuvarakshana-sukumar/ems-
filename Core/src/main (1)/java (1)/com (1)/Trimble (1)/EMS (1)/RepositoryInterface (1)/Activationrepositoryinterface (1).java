package com.Trimble.EMS.RepositoryInterface;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Trimble.EMS.Activations.*;

@Component("activationrepositoryinterface")
public interface Activationrepositoryinterface {
	ActivationResult findall(String entitlementId, int page, String token);

}
