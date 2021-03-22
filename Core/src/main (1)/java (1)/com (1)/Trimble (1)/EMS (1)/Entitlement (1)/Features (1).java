package com.Trimble.EMS.Entitlement;

public class Features {
	int featureId;
	String name;
	String version;
	String externalId;

	public Features() {
		super();
	}


	public int getFeatureId() {
		return featureId;
	}

	public void setFeatureId(int featureId) {
		this.featureId = featureId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[featureId=");
		builder.append(featureId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", version=");
		builder.append(version);
		builder.append(", externalId=");
		builder.append(externalId);
		builder.append("]");
		return builder.toString();
	}

}
