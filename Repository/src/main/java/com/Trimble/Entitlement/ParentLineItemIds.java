package com.Trimble.Entitlement;

public class ParentLineItemIds {
	String parentLineItemId;

	public ParentLineItemIds() {
		super();
	}



	public String getParentLineItemId() {
		return parentLineItemId;
	}

	public void setParentLineItemId(String parentLineItemId) {
		this.parentLineItemId = parentLineItemId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[parentLineItemId=");
		builder.append(parentLineItemId);
		builder.append("]");
		return builder.toString();
	}

}
