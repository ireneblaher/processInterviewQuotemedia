/**
 * 
 */
package com.quotemedia.interview.quoteservice.service;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.quotemedia.interview.quoteservice.model.Quote;
import com.quotemedia.interview.quoteservice.model.QuoteId;
import com.quotemedia.interview.quoteservice.repository.QuoteRepository;
import com.quotemedia.interview.quoteservice.service.impl.QuoteServiceImpl;


/**
 * 
 */
@SpringBootTest
public class QuoteServiceTest {

	    @Mock
	    private QuoteRepository quoteRepositoryMock;

	    @InjectMocks
	    private QuoteServiceImpl quoteService;	    

	    @SuppressWarnings({ "static-access", "rawtypes", "unused" })
		@Test
	    public void testGetQuoteBySymbol() {
	    	
	    	List<Quote> listQuote = new ArrayList<Quote>();
						
			ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
			assertEquals(response,quoteService.getQuotebySymbol("FBB"));
			response = new ResponseEntity(HttpStatus.BAD_REQUEST);
			assertEquals(response,quoteService.getQuotebySymbol("F"));
	    }
	    
	    @SuppressWarnings("rawtypes")
		@Test
	    public void testGetSymbolByDayMostAsk() {
	    	
			List<Quote> listQuote = new ArrayList<Quote>();
			Quote quote = new Quote();
			quote.setBid(6.12);
			quote.setAsk(6.33);		
			QuoteId quoteId = new QuoteId();
			quote.setQuoteId(quoteId);		
			Date date = stringToDate("2020-01-04");
			quote.getQuoteId().setDay(date);
			quote.getQuoteId().setSymbol("FB");
			
			listQuote.add(quote);

		
			ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
			assertEquals(response,quoteService.getSymbolbyDayMostAsk("2024-02-04"));
			response = new ResponseEntity(HttpStatus.BAD_REQUEST);
			assertEquals(response,quoteService.getSymbolbyDayMostAsk("20-20-20"));
	    }
	    
	    private Date stringToDate (String dateString) {
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        sdf.setLenient(false); 

		        Date date = new Date();
		        try {
		            date = sdf.parse(dateString);
		            
		            return date; 
		        } catch (ParseException e) {
		            
		        }
		        
		        return date;
		}
}
