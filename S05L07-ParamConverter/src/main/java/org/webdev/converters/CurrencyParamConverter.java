package org.webdev.converters;

import javax.ws.rs.ext.ParamConverter;

import org.webdev.Currency;

public class CurrencyParamConverter implements ParamConverter<Currency> {

	@Override
	public Currency fromString(String code) {
		
		Currency currency = null;
		
		switch(code.toUpperCase()) {
		case "EUR" : currency = new Currency("EUR","EURO");
		case "USD" : currency =  new Currency("USD","U DOLLAR");
		case "INR" : currency = new Currency("INR","RUPEE");
		}
		return currency;
	}

	@Override
	public String toString(Currency currency) {
		return currency.toString();
	}

}
