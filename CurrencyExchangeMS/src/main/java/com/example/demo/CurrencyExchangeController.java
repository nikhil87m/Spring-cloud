package com.example.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CurrencyExchangeService;

@RestController
@RequestMapping("/CurrencyExchangeController")
public class CurrencyExchangeController {
	private static Logger logger= LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/getExchangeValue")
	public BigDecimal getExchangeValue(@RequestParam(name="currencyFrom", required = false) String currencyFrom, @RequestParam(name="currencyTo", required = false) String currencyTo){
		logger.debug("Entry : getExchangeValue: currencyFrom:"+currencyFrom+"currencyTo :"+currencyTo);
		BigDecimal cf = currencyExchangeService.getConversionfactor(currencyFrom, currencyTo);
		logger.debug("Exit : getExchangeValue");
		return cf;
	}
	
	@GetMapping("/updateCurrencyFactor")
	public ResponseEntity<String> updateCurrencyFactor(@RequestParam(name="currencyFrom", required = false) String currencyFrom, @RequestParam(name="currencyTo", required = false) String currencyTo, @RequestParam(name="conversionFactor", required = false) BigDecimal conversionFactor ){
		logger.debug("Entry : updateCurrencyFactor");
		String msg = currencyExchangeService.updateCurrencyFactor(currencyFrom, currencyTo, conversionFactor);
		logger.debug("Exit : updateCurrencyFactor");
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
	
	@GetMapping("/addCurrencyFactor")
	public ResponseEntity<String> addCurrencyFactor(@RequestParam(name="currencyFrom", required = false) String currencyFrom, @RequestParam(name="currencyTo", required = false) String currencyTo, @RequestParam(name="conversionFactor", required = false) BigDecimal conversionFactor){
		logger.debug("Entry : addCurrencyFactor");
		String msg = currencyExchangeService.addCurrencyFactor(currencyFrom, currencyTo, conversionFactor);
		logger.debug("Exit : addCurrencyFactor");
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}

}
