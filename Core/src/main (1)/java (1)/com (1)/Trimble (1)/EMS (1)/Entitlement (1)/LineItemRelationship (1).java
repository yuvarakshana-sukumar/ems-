package com.Trimble.EMS.Entitlement;

import java.util.List;

public class LineItemRelationship {
	List<ParentLineItemIds> parentLineItemIds;

	public LineItemRelationship() {
		super();
	}



	public List<ParentLineItemIds> getParentLineItemIds() {
		return parentLineItemIds;
	}

	public void setParentLineItemIds(List<ParentLineItemIds> parentLineItemIds) {
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
