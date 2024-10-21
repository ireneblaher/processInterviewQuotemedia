/**
 * 
 */
package com.quotemedia.interview.quoteservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quotemedia.interview.quoteservice.service.QuoteService;

/**
 * Controller and endpoints
 */
@Controller
public class QuoteController {

	@Autowired
	QuoteService quoteService;
	
	/**
	 * Get ask, bid from Quote and status
	 * @param symbol
	 * @return
	 */
	@GetMapping("/getquotebysymbol/{symbol}")
	ResponseEntity<?> getQuotebySymbol(@PathVariable String symbol) {		
		return quoteService.getQuotebySymbol(symbol);	
	}
	
	/**
	 * Get symbol whit most ask by day
	 * @param day
	 * @return
	 */
	@GetMapping("/getsymbolmostaskbyday/{day}")
	ResponseEntity<?> getSymbolbyDay(@PathVariable String day) {		
		return quoteService.getSymbolbyDayMostAsk(day);	
	}
}
