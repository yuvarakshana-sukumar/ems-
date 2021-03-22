package com.Trimble.Entitlement;

public class OrderClosedDate {
	int year;
	int month;
	int day;

	public OrderClosedDate() {
		super();
	}



	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDate() {
		return day;
	}

	public void setDate(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[year=");
		builder.append(year);
		builder.append(", month=");
		builder.append(month);
		builder.append(", day=");
		builder.append(day);
		builder.append("]");
		return builder.toString();
	}

}
