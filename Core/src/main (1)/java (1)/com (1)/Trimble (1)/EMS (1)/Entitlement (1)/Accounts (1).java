package com.Trimble.EMS.Entitlement;

public class Accounts {
	String accountId;
	String name;
	String type;
	boolean isPrimary;
	String localId;

	public Accounts() {
		super();
	}



	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[accountId=");
		builder.append(accountId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", isPrimary=");
		builder.append(isPrimary);
		builder.append(", localId=");
		builder.append(localId);
		builder.append("]");
		return builder.toString();
	}

}
