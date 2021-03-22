package com.Trimble.EMS.Token;

public class Token {
	String access_token;
	String token_type;
	int expires_in;

	public Token() {
		super();
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[access_token=");
		builder.append(access_token);
		builder.append(", token_type=");
		builder.append(token_type);
		builder.append(", expires_in=");
		builder.append(expires_in);
		builder.append("]");
		return builder.toString();
	}

}
