package com.Trimble.EMS.Entitlement;

import java.util.List;

public class Entitlement {

	String entitlementId;
	String shippingId;
	StartDate startDate;
	EndDate endDate;
	String source;
	String orderNumber;
	String contractNumber;
	OrderClosedDate orderClosedDate;
	String purchaseOrder;
	boolean activateSAAS;
	String entitlementState;
	List<LineItems> lineItems;
	List<Accounts> accounts;
	String entitlementRelationalId;

	public Entitlement() {
		super();
	}



	public String getEntitlementId() {
		return entitlementId;
	}

	public void setEntitlementId(String entitlementId) {
		this.entitlementId = entitlementId;
	}

	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	public StartDate getStartDate() {
		return startDate;
	}

	public void setStartDate(StartDate startDate) {
		this.startDate = startDate;
	}

	public EndDate getEndDate() {
		return endDate;
	}

	public void setEndDate(EndDate endDate) {
		this.endDate = endDate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public OrderClosedDate getOrderClosedDate() {
		return orderClosedDate;
	}

	public void setOrderClosedDate(OrderClosedDate orderClosedDate) {
		this.orderClosedDate = orderClosedDate;
	}

	public String getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public boolean isActivateSAAS() {
		return activateSAAS;
	}

	public void setActivateSAAS(boolean activateSAAS) {
		this.activateSAAS = activateSAAS;
	}

	public String getEntitlementState() {
		return entitlementState;
	}

	public void setEntitlementState(String entitlementState) {
		this.entitlementState = entitlementState;
	}

	public List<LineItems> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItems> lineItems) {
		this.lineItems = lineItems;
	}

	public List<Accounts> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Accounts> accounts) {
		this.accounts = accounts;
	}

	public String getEntitlementRelationalId() {
		return entitlementRelationalId;
	}

	public void setEntitlementRelationalId(String entitlementRelationalId) {
		this.entitlementRelationalId = entitlementRelationalId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[entitlementId=");
		builder.append(entitlementId);
		builder.append(", shippingId=");
		builder.append(shippingId);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", source=");
		builder.append(source);
		builder.append(", orderNumber=");
		builder.append(orderNumber);
		builder.append(", contractNumber=");
		builder.append(contractNumber);
		builder.append(", orderClosedDate=");
		builder.append(orderClosedDate);
		builder.append(", purchaseOrder=");
		builder.append(purchaseOrder);
		builder.append(", activateSAAS=");
		builder.append(activateSAAS);
		builder.append(", entitlementState=");
		builder.append(entitlementState);
		builder.append(", lineItems=");
		builder.append(lineItems);
		builder.append(", accounts=");
		builder.append(accounts);
		builder.append(", entitlementRelationalId=");
		builder.append(entitlementRelationalId);
		builder.append("]");
		return builder.toString();
	}

}
