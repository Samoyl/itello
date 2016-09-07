package se.itello.example.payments.model;

import java.math.BigDecimal;

public class PaymentPost {

	private BigDecimal amount;

	private String referenceNumber;

	public String getReferens() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
