package com.Trimble.Entitlement;

import java.util.List;

public class LineItemRelationship {
	List<com.Trimble.Entitlement.ParentLineItemIds> parentLineItemIds;

	public LineItemRelationship() {
		super();
	}



	public List<com.Trimble.Entitlement.ParentLineItemIds> getParentLineItemIds() {
		return parentLineItemIds;
	}

	public void setParentLineItemIds(List<com.Trimble.Entitlement.ParentLineItemIds> parentLineItemIds) {
		this.parentLineItemIds = parentLineItemIds;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[parentLineItemIds=");
		builder.append(parentLineItemIds);
		builder.append("]");
		return builder.toString();
	}

}
