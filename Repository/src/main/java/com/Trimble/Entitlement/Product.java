package com.Trimble.Entitlement;

import java.util.List;

public class Product {
	String name;
	String desc;
	int productId;
	String sku;
	List<com.Trimble.Entitlement.Features> features;
	boolean isSAAS;
	boolean allowMultipleAssignment;

	public Product() {
		super();
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public List<com.Trimble.Entitlement.Features> getFeatures() {
		return features;
	}

	public void setFeatures(List<com.Trimble.Entitlement.Features> features) {
		this.features = features;
	}

	public boolean isSAAS() {
		return isSAAS;
	}

	public void setSAAS(boolean isSAAS) {
		this.isSAAS = isSAAS;
	}

	public boolean isAllowMultipleAssignment() {
		return allowMultipleAssignment;
	}

	public void setAllowMultipleAssignment(boolean allowMultipleAssignment) {
		this.allowMultipleAssignment = allowMultipleAssignment;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[name=");
		builder.append(name);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", sku=");
		builder.append(sku);
		builder.append(", features=");
		builder.append(features);
		builder.append(", isSAAS=");
		builder.append(isSAAS);
		builder.append(", allowMultipleAssignment=");
		builder.append(allowMultipleAssignment);
		builder.append("]");
		return builder.toString();
	}

}
