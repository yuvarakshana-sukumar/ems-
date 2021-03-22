package com.Trimble.Entitlement;

import java.util.List;

public class LineItemActivationAttributes {
	List<com.Trimble.Entitlement.AttributeGroups> attributeGroups;

	public LineItemActivationAttributes() {
		super();
	}



	public List<com.Trimble.Entitlement.AttributeGroups> getAttributeGroups() {
		return attributeGroups;
	}

	public void setAttributeGroups(List<com.Trimble.Entitlement.AttributeGroups> attributeGroups) {
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
