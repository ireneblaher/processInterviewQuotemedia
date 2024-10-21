/**
 * 
 */
package com.quotemedia.interview.quoteservice.service;

import org.springframework.http.ResponseEntity;

/**
 * QuoteService interface class
 */
public interface QuoteService {

	@SuppressWarnings("rawtypes")
	ResponseEntity getQuotebySymbol(String symbol);

	@SuppressWarnings("rawtypes")
	ResponseEntity getSymbolbyDayMostAsk(String day);

}
