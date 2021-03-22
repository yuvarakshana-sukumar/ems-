package com.Trimble.Activations;

public class Activationdetails {

	String activationId;
	int quantity;
	String productName;
	com.Trimble.Activations.Activation activation;

	public Activationdetails() {
		super();
	}



	public String getActivationId() {
		return activationId;
	}

	public void setActivationId(String activationId) {
		this.activationId = activationId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public com.Trimble.Activations.Activation getActivation() {
		return activation;
	}

	public void setActivation(com.Trimble.Activations.Activation activation) {
		this.activation = activation;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[activationId=");
		builder.append(activationId);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", activation=");
		builder.append(activation);
		builder.append("]");
		return builder.toString();
	}

}
