package se.itello.example.payments.main;

import java.util.Scanner;

import se.itello.example.payments.PaymentReceiver;
import se.itello.example.payments.exception.PaymentDataProcessException;
import se.itello.example.payments.impl.PaymentReceiverImpl;
import se.itello.example.payments.model.PaymentPost;

public class PaymentMain {

	private static PaymentReceiver paymentReceiver = new PaymentReceiverImpl();
	private static PaymentDataProcessor paymentDataProcessor = null;
	private static Bundle paymentBundle;

	public static void main(String[] args) {
		// Get Data
		System.out.println("Enter payment file Path: ");
		Scanner scanner = new Scanner(System.in);
		String filePath = scanner.nextLine();
		System.out.println("Enter payment file name: ");
		String fileName = scanner.nextLine();
		scanner.close();
		if (fileName.contains("_betalningsservice.txt")) {
			paymentDataProcessor = new BePaymentDataProcessor();
		} else if (fileName.contains("_inbetalningstjansten.txt")) {
			paymentDataProcessor = new InPaymentDataProcessor();
		} else {
			System.err.println(
					"The input type is not valid: Valid types Exempelfil_betalningsservice.txt or Exempelfil_inbetalningstjansten.txt");
			System.exit(-1);
		}
		try {
			paymentBundle = paymentDataProcessor.process(filePath + "\\" + fileName);
		} catch (PaymentDataProcessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		paymentReceiver.startPaymentBundle(paymentBundle.getOpningPost().getFullAccount(),
				paymentBundle.getOpningPost().getDate(), paymentBundle.getOpningPost().getCurrency());

		for (PaymentPost paymentPost : paymentBundle.getPaymentPost()) {
			paymentReceiver.payment(paymentPost.getAmount(), paymentPost.getReferens());
		}
		paymentReceiver.endPaymentBundle();
	}

}
