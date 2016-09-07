package se.itello.example.payments.main;

import java.util.List;

import se.itello.example.payments.model.OpeningPost;
import se.itello.example.payments.model.PaymentPost;
import se.itello.example.payments.model.CloseingPost;

public class Bundle {

	private OpeningPost OpningPost;

	private List<PaymentPost> paymentPost;

	private CloseingPost CloseingPost;

	public OpeningPost getOpningPost() {
		return OpningPost;
	}

	public void setOpningPost(OpeningPost opningPost) {
		OpningPost = opningPost;
	}

	public List<PaymentPost> getPaymentPost() {
		return paymentPost;
	}

	public void setPaymentPost(List<PaymentPost> paymentPost) {
		this.paymentPost = paymentPost;
	}

	public CloseingPost getCloseingPost() {
		return CloseingPost;
	}

	public void setCloseingPost(CloseingPost closeingPost) {
		CloseingPost = closeingPost;
	}

}
