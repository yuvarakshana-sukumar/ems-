package com.Trimble.Entitlement;

public class Attributes {
	String name;
	String value;
	boolean readOnly;

	public Attributes() {
		super();
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append(", readOnly=");
		builder.append(readOnly);
		builder.append("]");
		return builder.toString();
	}

}
