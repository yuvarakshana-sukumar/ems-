package com.Trimble.Activations;

import java.util.List;

public class AttributeGroups {
	String name;
	List<com.Trimble.Activations.Attributes> attributes;

	public AttributeGroups() {
		super();
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<com.Trimble.Activations.Attributes> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<com.Trimble.Activations.Attributes> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[name=");
		builder.append(name);
		builder.append(", attributes=");
		builder.append(attributes);
		builder.append("]");
		return builder.toString();
	}

}
