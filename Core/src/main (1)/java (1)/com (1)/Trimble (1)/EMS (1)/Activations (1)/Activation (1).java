package com.Trimble.EMS.Activations;

public class Activation {
	String activationId;
	String entitlementId;
	String lineItemId;
	String activatorId;
	boolean isActive;
	ActivationDate activationDate;
	ExpiryDate expiryDate;
	String currentState;
	LineItemActivationAttributes lineItemActivationAttributes;
	String trn;

	public Activation() {
		super();
	}



	public String getActivationId() {
		return activationId;
	}

	public void setActivationId(String activationId) {
		this.activationId = activationId;
	}

	public String getEntitlementId() {
		return entitlementId;
	}

	public void setEntitlementId(String entitlementId) {
		this.entitlementId = entitlementId;
	}

	public String getLineItemId() {
		return lineItemId;
	}

	public void setLineitemId(String lineItemId) {
		this.lineItemId = lineItemId;
	}

	public String getActivatorId() {
		return activatorId;
	}

	public void setActivatorId(String activatorId) {
		this.activatorId = activatorId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public ActivationDate getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(ActivationDate activationDate) {
		this.activationDate = activationDate;
	}

	public ExpiryDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(ExpiryDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public LineItemActivationAttributes getLineItemActivationAttributes() {
		return lineItemActivationAttributes;
	}

	public void setLineItemActivationAttributes(LineItemActivationAttributes lineItemActivationAttributes) {
		this.lineItemActivationAttributes = lineItemActivationAttributes;
	}

	public String getTrn() {
		return trn;
	}

	public void setTrn(String trn) {
		this.trn = trn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[activationId=");
		builder.append(activationId);
		builder.append(", entitlementId=");
		builder.append(entitlementId);
		builder.append(", lineItemId=");
		builder.append(lineItemId);
		builder.append(", activatorId=");
		builder.append(activatorId);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", activationDate=");
		builder.append(activationDate);
		builder.append(", expiryDate=");
		builder.append(expiryDate);
		builder.append(", currentState=");
		builder.append(currentState);
		builder.append(", lineItemActivationAttributes=");
		builder.append(lineItemActivationAttributes);
		builder.append(", trn=");
		builder.append(trn);
		builder.append("]");
		return builder.toString();
	}

}
