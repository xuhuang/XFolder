package com.videostore.bean;

public class Transaction {
	private String transacid;
	private String datetime;
	private String amount;
	private String type;
	private String memberid;
	public String getTransacid() {
		return transacid;
	}
	public void setTransacid(String transacid) {
		this.transacid = transacid;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	@Override
	public String toString() {
		return "Transaction [transacid=" + transacid + ", datetime=" + datetime
				+ ", amount=" + amount + ", type=" + type + ", memberid="
				+ memberid + "]";
	}
	
}
