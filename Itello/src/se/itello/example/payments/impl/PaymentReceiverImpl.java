package se.itello.example.payments.impl;

import java.math.BigDecimal;
import java.util.Date;

import se.itello.example.payments.PaymentReceiver;

public class PaymentReceiverImpl implements PaymentReceiver {

	@Override
	public void startPaymentBundle(String accountNumber, Date paymentDate, String currency) {
		// TODO Auto-generated method stub
		System.out.println("Entring startPaymentBundle.");
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Payment Date: " + paymentDate);
		System.out.println("Currency: " + currency);
		System.out.println("Leaving startPaymentBundle.");
		System.out.println();
	}

	@Override
	public void payment(BigDecimal amount, String reference) {
		// TODO Auto-generated method stub
		System.out.println("Entring payment.");
		System.out.println("Amount: " + amount);
		System.out.println("Reference: " + reference);
		System.out.println("Leaving payment.");
		System.out.println();
		
	}

	@Override
	public void endPaymentBundle() {
		// TODO Auto-generated method stub
		System.out.println("Entring endPaymentBundle.");
		System.out.println("Leaving endPaymentBundle.");
	}

}
