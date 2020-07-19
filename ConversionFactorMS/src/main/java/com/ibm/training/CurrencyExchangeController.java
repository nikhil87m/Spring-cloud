package com.ibm.training;

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

import com.ibm.training.service.CurrencyExchangeService;

@RestController
@RequestMapping("/CurrencyExchangeController")
public class CurrencyExchangeController {
	private static Logger logger= LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/getConversionfactor")
	public BigDecimal getCurrencyFactor(@RequestParam(name="currencyFrom", required = false) String currencyFrom, @RequestParam(name="currencyTo", required = false) String currencyTo){
		logger.debug("Entry : getConversionfactor: currencyFrom:"+currencyFrom+"currencyTo :"+currencyTo);
		BigDecimal cf = currencyExchangeService.getConversionfactor(currencyFrom, currencyTo);
		logger.debug("Exit : getConversionfactor");
		return cf;
	}
	
	@GetMapping("/updateConversionFactor")
	public ResponseEntity<String> updateConversionFactor(@RequestParam(name="currencyFrom", required = false) String currencyFrom, @RequestParam(name="currencyTo", required = false) String currencyTo, @RequestParam(name="conversionFactor", required = false) BigDecimal conversionFactor ){
		logger.debug("Entry : updateConversionFactor");
		String msg = currencyExchangeService.updateConversionFactor(currencyFrom, currencyTo, conversionFactor);
		logger.debug("Exit : updateConversionFactor");
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
	
	@GetMapping("/addConversionFactor")
	public ResponseEntity<String> addConversionFactor(@RequestParam(name="currencyFrom", required = false) String currencyFrom, @RequestParam(name="currencyTo", required = false) String currencyTo, @RequestParam(name="conversionFactor", required = false) BigDecimal conversionFactor){
		logger.debug("Entry : addConversionFactor");
		String msg = currencyExchangeService.addConversionFactor(currencyFrom, currencyTo, conversionFactor);
		logger.debug("Exit : addConversionFactor");
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}

}
