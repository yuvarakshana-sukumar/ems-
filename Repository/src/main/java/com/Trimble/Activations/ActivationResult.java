package com.Trimble.Activations;

import java.util.List;

public class ActivationResult {

	List<Activationdetails> list;
	int totalRecordCount;

	public ActivationResult(List<Activationdetails> list, int totalRecordCount) {
		super();
		this.list = list;
		this.totalRecordCount = totalRecordCount;
	}

	public List<Activationdetails> getList() {
		return list;
	}

	public void setList(List<Activationdetails> list) {
		this.list = list;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[list=");
		builder.append(list);
		builder.append(", totalRecordCount=");
		builder.append(totalRecordCount);
		builder.append("]");
		return builder.toString();
	}

}
