package com.Trimble.EMS.Entitlement;

public class StartDate {
	private String year;
	private String month;
	private String day;

	public StartDate() {
		super();
	}



	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDate(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(year);
		builder.append("/");
		builder.append(month);
		builder.append("/");
		builder.append(day);
		return builder.toString();
	}
}
