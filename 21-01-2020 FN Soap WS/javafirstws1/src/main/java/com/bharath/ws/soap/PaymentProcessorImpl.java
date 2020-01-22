package com.bharath.ws.soap;

import java.time.LocalDate;

import com.bharath.ws.soap.dto.PaymentProcessorRequest;
import com.bharath.ws.soap.dto.PaymentProcessorResponse;

public class PaymentProcessorImpl implements PaymentProcessor {
	
	public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) {
		
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();
		
		// Business Logic or a call to a Business Logic Class Goes Here.
		if(paymentProcessorRequest.getCreditCardInfo().getCardNumber().length()<5) {
			throw new RuntimeException("Please enter a valid length card number");
		}
		
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}
	
	public PaymentProcessorResponse isCardValid(PaymentProcessorRequest paymentProcessorRequest) {
		
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();
	
		String expiry = paymentProcessorRequest.getCreditCardInfo().getExpirtyDate();
		if(expiry.length() != 5)
			throw new RuntimeException("Invalid expiry date and provide in this [format: MM/YY]");
		
		String[] split = expiry.split("/");
		int emonth = Integer.parseInt(split[0]);
		int eyear = Integer.parseInt(split[1]);
		System.out.println(emonth + " " + eyear);
		
		LocalDate localDate = LocalDate.now();
		int month = localDate.getMonthValue(); 
		int year = localDate.getYear() - 2000;
		
		if(eyear < year || (eyear == year && emonth <= month))
			throw new RuntimeException("Card is expired!");
		
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
