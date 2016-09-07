package se.itello.example.payments.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import se.itello.example.payments.enums.PostType;
import se.itello.example.payments.exception.PaymentDataException;
import se.itello.example.payments.exception.PaymentDataProcessException;
import se.itello.example.payments.model.CloseingPost;
import se.itello.example.payments.model.OpeningPost;
import se.itello.example.payments.model.PaymentPost;

public class InPaymentDataProcessor extends PaymentDataProcessor {

	@Override
	protected Bundle process(String file) throws PaymentDataProcessException {
		Bundle paymentBundle = new Bundle();
		OpeningPost openingPost = new OpeningPost();
		PaymentPost paymentPost;
		CloseingPost closeingPost = new CloseingPost();
		List<PaymentPost> inPyPost = new ArrayList<>();

		try {
			List<String> lines = parse(file);
			for (String line : lines) {
				if (line.startsWith(PostType.start.getValue())) {

					String clearingNumber = line.substring(10, 14).trim();
					openingPost.setClearingNumber(clearingNumber);

					String accountNumber = line.substring(14, 24).trim();
					openingPost.setAccountNumber(accountNumber);

					paymentBundle.setOpningPost(openingPost);

				} else if (line.startsWith(PostType.pay.getValue())) {

					paymentPost = new PaymentPost();

					Integer belopp = Integer.valueOf(line.substring(2, 22).trim());
					paymentPost.setAmount(new BigDecimal(belopp));

					String Referens = line.substring(40).trim();
					paymentPost.setReferenceNumber(Referens);

					inPyPost.add(paymentPost);
					paymentBundle.setPaymentPost(inPyPost);

				} else if (line.startsWith(PostType.end.getValue())) {
					
					Integer sum = Integer.valueOf(line.substring(2, 22).trim());
					closeingPost.setSum(new BigDecimal(sum));

					int quantity = Integer.valueOf(line.substring(30, 38).trim());
					closeingPost.setQuantity(quantity);
					
					paymentBundle.setCloseingPost(closeingPost);
				} else {
					System.err.println("There is wrong with the file.");
				}
			}

			return paymentBundle;
		} catch (PaymentDataException e) {
			throw new PaymentDataProcessException(e);
		}

	}

}
