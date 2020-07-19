package com.ibm.training;

import java.math.BigDecimal;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("conversion-factor-service")
@RibbonClient(name="conversion-factor-service") 
public interface RestClient {
	
	@GetMapping("/CurrencyExchangeController/getConversionfactor")
	public BigDecimal getConversionfactor(@RequestParam String currencyFrom, @RequestParam String currencyTo);

}