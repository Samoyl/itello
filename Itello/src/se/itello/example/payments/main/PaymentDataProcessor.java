package se.itello.example.payments.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import se.itello.example.payments.exception.PaymentDataException;
import se.itello.example.payments.exception.PaymentDataProcessException;

public abstract class PaymentDataProcessor {

	protected abstract Bundle process(String file) throws PaymentDataProcessException;
	
	protected List<String> parse(String file) throws PaymentDataException {
		List<String> list = new ArrayList<>();
		try (BufferedReader br = Files.newBufferedReader(Paths.get(file))) {
			list = br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			throw new PaymentDataException(e);
		}
		return list;
	}
}
