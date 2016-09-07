package se.itello.example.payments.model;

import java.math.BigDecimal;
import java.util.Date;

public class OpeningPost {

	private String accountNumber;

	private String clearingNumber;

	private BigDecimal amount;

	private Integer quantity;

	private String currency;

	private Date date;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal number) {
		this.amount = number;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getClearingNumber() {
		return clearingNumber;
	}

	public void setClearingNumber(String clearingNumber) {
		this.clearingNumber = clearingNumber;
	}

	public String getFullAccount() {
		return clearingNumber + " " + accountNumber;

	}

}
