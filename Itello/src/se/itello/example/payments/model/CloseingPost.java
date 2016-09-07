package se.itello.example.payments.model;

import java.math.BigDecimal;

public class CloseingPost {

	private BigDecimal sum;

	private Integer quantity;

	public BigDecimal getSum() {
		return sum;
	}

	public void setSum(BigDecimal number) {
		this.sum = number;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
