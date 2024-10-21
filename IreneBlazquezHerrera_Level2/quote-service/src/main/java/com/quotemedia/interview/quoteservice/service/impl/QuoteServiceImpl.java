/**
 * 
 */
package com.quotemedia.interview.quoteservice.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quotemedia.interview.quoteservice.repository.QuoteRepository;
import com.quotemedia.interview.quoteservice.service.QuoteService;
import com.quotemedia.interview.quoteservice.model.Response;
import com.quotemedia.interview.quoteservice.model.Quote;

/**
 * Service class, all the implementation is here
 * information treatment and get the response
 */
@Service
public class QuoteServiceImpl implements QuoteService{
	
	@Autowired
	QuoteRepository quoteRepository;
	
	@Autowired
	Response response;
	
	public static final int MIN_VALUE_SYMBOL = 2;
	public static final int MAX_VALUE_SYMBOL = 6;
	public static final String DAY_FORMAT = "yyyy-MM-dd";
	
	private static boolean dateValid = false;
	private static boolean dateFormatValid = false;
	
	private static Date date = new Date();
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public ResponseEntity getQuotebySymbol(String symbol) {
		
		//Before making the query we validate the symbol		
		if (symbol.length() < MIN_VALUE_SYMBOL || symbol.length() > MAX_VALUE_SYMBOL){
        	//If data exists and symbol is not valid, return 400
        	return ResponseEntity.badRequest().build();
        }
		
		//Making the query
		List<Quote> quoteList = quoteRepository.findQuotebySymbol(symbol);
		if (quoteList == null || quoteList.isEmpty()) {
            //If no data exists for the symbol, return 404 Not Found
            return ResponseEntity.notFound().build();
        } else {
        	//If data exists and symbol valid, return 200 OK with the quote(bid,ask)    
        	response.setAsk(quoteList.get(0).getAsk());  
        	response.setBid(quoteList.get(0).getBid());
        	
            return ResponseEntity.ok(response);
        }
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ResponseEntity getSymbolbyDayMostAsk(String dayString) {		
		
		//Before making the query we validate the format date
		if(!dateFormatValidator(dayString, DAY_FORMAT) || !dateValidator(dayString, DAY_FORMAT)) {
			//If day not valid, return 400quoteList
        	return ResponseEntity.badRequest().build();
		}
		
		List<Quote> quoteList = quoteRepository.findSymbolbyDayMostAsk(date);
		
		if (dateValid && dateFormatValid && (quoteList == null || quoteList.isEmpty())) {
			
			//Day valid, but not result return 404
            return ResponseEntity.notFound().build();
		} else {
			//Day valid and result, return 202 OK	
			String symbol = quoteList.get(0).getQuoteId().getSymbol();
			
			return ResponseEntity.ok("{\"symbol\":"+symbol+"}");			
		}
	}
	
	
	private static boolean dateFormatValidator(String dateString, String format) {
		
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false); 
        
        try {
            sdf.parse(dateString);
            dateFormatValid = true;
            return dateFormatValid; 
        } catch (ParseException e) {
            return false;         }
    }

    private static boolean dateValidator(String dateString, String format) {
    	
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false); 

        try {
            date = sdf.parse(dateString);
            dateValid = true;
            return dateValid; 
        } catch (ParseException e) {
            return false; 
        }
    }
	
}
