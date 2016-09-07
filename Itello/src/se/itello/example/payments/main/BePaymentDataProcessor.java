package se.itello.example.payments.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import se.itello.example.payments.enums.PostType;
import se.itello.example.payments.exception.PaymentDataException;
import se.itello.example.payments.exception.PaymentDataProcessException;
import se.itello.example.payments.model.OpeningPost;
import se.itello.example.payments.model.PaymentPost;

public class BePaymentDataProcessor extends PaymentDataProcessor {

	public Date getLocalDate(String input) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate localDate = LocalDate.parse(input, format);
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return date;
	}
	
	@Override
	protected Bundle process(String file) throws PaymentDataProcessException {
		Bundle paymentBundle = new Bundle();
		OpeningPost openingPost = new OpeningPost();
		List<PaymentPost> inPyPost = new ArrayList<>();
		try {
			List<String> lines = parse(file);
			for (String line : lines) {
				if (line.startsWith(PostType.O.name())) {
					
					String clearingNumber = line.substring(1, 5).trim();
					openingPost.setClearingNumber(clearingNumber);
					
					String accountNumber = line.substring(6, 16).trim();
					openingPost.setAccountNumber(accountNumber);
					
					Integer sum = Integer.valueOf(line.substring(16, 30).trim());
					openingPost.setAmount(new BigDecimal(sum));
					
					Integer Quantity = Integer.valueOf(line.substring(30, 40).trim());
					openingPost.setQuantity(Quantity);
					
					Date PaymentDate = getLocalDate(line.substring(40, 48).trim());
					openingPost.setDate(PaymentDate);
					
					String currency = line.substring(48).trim();
					openingPost.setCurrency(currency);
					
					paymentBundle.setOpningPost(openingPost);
				} else if (line.startsWith(PostType.B.name())) {
					PaymentPost paymentPost = new PaymentPost();
					
					String belopp = line.substring(1, 15).trim();
					paymentPost.setAmount(new BigDecimal(belopp.replace(",", ".")));
					
					String Referens = line.substring(15).trim();
					paymentPost.setReferenceNumber(Referens);
					
					inPyPost.add(paymentPost);
					paymentBundle.setPaymentPost(inPyPost);
				}
			}

			return paymentBundle;
		} catch (PaymentDataException e) {
			throw new PaymentDataProcessException(e);
		}

	}

}
