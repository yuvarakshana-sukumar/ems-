package com.Trimble.EMS.Activations;

public class ActivationDate {
	int year;
	int month;
	int day;

	public ActivationDate() {
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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
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
