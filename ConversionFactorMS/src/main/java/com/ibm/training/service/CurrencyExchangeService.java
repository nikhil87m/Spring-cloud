package com.ibm.training.service;

import java.math.BigDecimal;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.ibm.training.entity.ExchangeEntity;
import com.ibm.training.repository.ExchangeRepository;

@Service
public class CurrencyExchangeService {
	private static Logger logger= LoggerFactory.getLogger(CurrencyExchangeService.class);
	
	@Autowired
	private ExchangeRepository exchangeRepository;
	
	public BigDecimal getConversionfactor(String currencyFrom, String currencyTo) {
		logger.debug("ENTRY : getConversionfactor: currencyFrom :"+currencyFrom+"currencyTo :"+currencyTo);
		ExchangeEntity exchangeEntity = exchangeRepository.findByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo);
		logger.debug("EXIT : getConversionfactor: exchangeEntity:"+exchangeEntity);
		return exchangeEntity.getConversionFactor();
	}
	
	public String updateConversionFactor(String currencyFrom, String currencyTo, BigDecimal consersionfactor) {
		logger.debug("ENTRY : updateConversionFactor: currencyFrom :"+currencyFrom+"currencyTo :"+currencyTo);
		ExchangeEntity exchangeEntity = new ExchangeEntity();
		exchangeEntity = exchangeRepository.findByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo);
		exchangeEntity.setConversionFactor(consersionfactor);
		exchangeRepository.save(exchangeEntity);
		logger.debug("EXIT : updateConversionFactor: exchangeEntity:"+exchangeEntity);
		return "Conversion Factor updated sucessfully";
	}
	
	public String addConversionFactor(String currencyFrom, String currencyTo, BigDecimal consersionfactor) {
		logger.debug("ENTRY : addConversionFactor: currencyFrom :"+currencyFrom+"currencyTo :"+currencyTo+"consersionfactor :"+consersionfactor);
		ExchangeEntity exchangeEntity = new ExchangeEntity();
		exchangeEntity.setConversionFactor(consersionfactor);
		exchangeEntity.setCurrencyFrom(currencyFrom);
		exchangeEntity.setCurrencyTo(currencyTo);
		Random rd = new Random();
		exchangeEntity.setId(rd.nextInt());
		exchangeRepository.save(exchangeEntity);
		logger.debug("EXIT : addConversionFactor: exchangeEntity:");
		return "CurrencyFactor added sucessfully";
	}

}
