package com.example.service;

import java.math.BigDecimal;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.ExchangeEntity;
import com.example.repo.ExchangeRepository;

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
	
	public String updateCurrencyFactor(String currencyFrom, String currencyTo, BigDecimal consersionfactor) {
		logger.debug("ENTRY : updateCurrencyFactor: currencyFrom :"+currencyFrom+"currencyTo :"+currencyTo);
		ExchangeEntity exchangeEntity = new ExchangeEntity();
		exchangeEntity = exchangeRepository.findByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo);
		exchangeEntity.setConversionFactor(consersionfactor);
		exchangeRepository.save(exchangeEntity);
		logger.debug("EXIT : updateCurrencyFactor: exchangeEntity:"+exchangeEntity);
		return "CurrencyFactor updated sucessfully";
	}
	
	public String addCurrencyFactor(String currencyFrom, String currencyTo, BigDecimal consersionfactor) {
		logger.debug("ENTRY : addCurrencyFactor: currencyFrom :"+currencyFrom+"currencyTo :"+currencyTo+"consersionfactor :"+consersionfactor);
		ExchangeEntity exchangeEntity = new ExchangeEntity();
		exchangeEntity.setConversionFactor(consersionfactor);
		exchangeEntity.setCurrencyFrom(currencyFrom);
		exchangeEntity.setCurrencyTo(currencyTo);
		Random rd = new Random();
		exchangeEntity.setId(rd.nextInt());
		exchangeRepository.save(exchangeEntity);
		logger.debug("EXIT : addCurrencyFactor: exchangeEntity:");
		return "CurrencyFactor added sucessfully";
	}

}
