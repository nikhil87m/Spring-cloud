package com.ibm.training.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.CurrencyConversionController;
import com.ibm.training.RestClient;

@Service
public class CurrencyConversionService {
	
	private static Logger logger= LoggerFactory.getLogger(CurrencyConversionController.class);
	
	@Autowired
	private RestClient restClient;
	
	public BigDecimal convertCurrency(String currencyFrom, String currencyTo, BigDecimal amount) {
		logger.debug("Entry : convertCurrency: currencyFrom:"+currencyFrom+"currencyTo :"+currencyTo+"amount"+amount);
		BigDecimal x = restClient.getConversionfactor(currencyFrom, currencyTo);
		BigDecimal ca =  amount.multiply(x);
		logger.debug("Exit : convertCurrency: calculated amount "+ca);
		return ca;

	}

}