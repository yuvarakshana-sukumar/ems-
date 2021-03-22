package com.Trimble.EMS.Entitlement;

public class LineItems {

	String lineItemId;
	StartDate startDate;
	EndDate endDate;
	int totalQuantity;
	int availableQuantity;
	Product product;
	LineItemActivationAttributes lineItemActivationAttributes;
	String lineItemState;
	LifeCycle lifeCycle;
	String activationMethod;
	LineItemRelationship lineItemRelationship;
	String childLineItemId;

	public LineItems() {
		super();
	}



	public String getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(String lineItemId) {
		this.lineItemId = lineItemId;
	}

	public StartDate getStartDate() {
		return startDate;
	}

	public void setStartDateLineItem(StartDate startDate) {
		this.startDate = startDate;
	}

	public EndDate getEndDate() {
		return endDate;
	}

	public void setEndDateLineItem(EndDate endDate) {
		this.endDate = endDate;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LineItemActivationAttributes getLineItemActivationAttributes() {
		return lineItemActivationAttributes;
	}

	public void setLineItemActivationAttributes(LineItemActivationAttributes lineItemActivationAttributes) {
		this.lineItemActivationAttributes = lineItemActivationAttributes;
	}

	public String getLineItemState() {
		return lineItemState;
	}

	public void setLineItemState(String lineItemState) {
		this.lineItemState = lineItemState;
	}

	public LifeCycle getLifeCycle() {
		return lifeCycle;
	}

	public void setLifeCycle(LifeCycle lifeCycle) {
		this.lifeCycle = lifeCycle;
	}

	public String getActivationMethod() {
		return activationMethod;
	}

	public void setActivationMethod(String activationMethod) {
		this.activationMethod = activationMethod;
	}

	public LineItemRelationship getLineItemRelationship() {
		return lineItemRelationship;
	}

	public void setLineItemRelationship(LineItemRelationship lineItemRelationship) {
		this.lineItemRelationship = lineItemRelationship;
	}

	public String getChildLineItemId() {
		return childLineItemId;
	}

	public void setChildLineItemId(String childLineItemId) {
		this.childLineItemId = childLineItemId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[lineItemId=");
		builder.append(lineItemId);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", totalQuantity=");
		builder.append(totalQuantity);
		builder.append(", availableQuantity=");
		builder.append(availableQuantity);
		builder.append(", product=");
		builder.append(product);
		builder.append(", lineItemActivationAttributes=");
		builder.append(lineItemActivationAttributes);
		builder.append(", lineItemState=");
		builder.append(lineItemState);
		builder.append(", lifeCycle=");
		builder.append(lifeCycle);
		builder.append(", activationMethod=");
		builder.append(activationMethod);
		builder.append(", lineItemRelationship=");
		builder.append(lineItemRelationship);
		builder.append(", childLineItemId=");
		builder.append(childLineItemId);
		builder.append("]");
		return builder.toString();
	}

}
