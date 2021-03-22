package com.Trimble.Activations;

import java.util.List;

public class LineItemActivationAttributes {
	List<AttributeGroups> attributeGroups;

	public LineItemActivationAttributes() {
		super();
	}



	public List<AttributeGroups> getAttributeGroups() {
		return attributeGroups;
	}

	public void setAttributeGroups(List<AttributeGroups> attributeGroups) {
		this.attributeGroups = attributeGroups;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[attributeGroups=");
		builder.append(attributeGroups);
		builder.append("]");
		return builder.toString();
	}

}
