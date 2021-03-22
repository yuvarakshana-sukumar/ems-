package com.Trimble.EMS.Members;

public class Member {
	String activationIdTRN;
	String memberId;
	String type;
	MemberSince memberSince;

	public Member() {
		super();
	}



	public String getActivationIdTRN() {
		return activationIdTRN;
	}

	public void setActivationIdTRN(String activationIdTRN) {
		this.activationIdTRN = activationIdTRN;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MemberSince getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(MemberSince memberSince) {
		this.memberSince = memberSince;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[activationIdTRN=");
		builder.append(activationIdTRN);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", type=");
		builder.append(type);
		builder.append(", memberSince=");
		builder.append(memberSince);
		builder.append("]");
		return builder.toString();
	}

}
