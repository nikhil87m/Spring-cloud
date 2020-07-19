package com.ibm.training;

public class Order {
	
	private String orderId;
	private String name;
	private String status = "NEW";
	private long amount;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", name=" + name + ", status=" + status + ", amount=" + amount + "]";
	}

	
}
