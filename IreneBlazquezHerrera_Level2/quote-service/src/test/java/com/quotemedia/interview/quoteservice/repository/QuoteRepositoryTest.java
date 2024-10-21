/**
 * 
 */
package com.quotemedia.interview.quoteservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.quotemedia.interview.quoteservice.model.Quote;

/**
 * 
 */
@SpringBootTest
public class QuoteRepositoryTest {

	@Mock 
	private QuoteRepository quoteRepositoryMock;
	
	@Test
	public void testFindQuoteBySymbol() {
				
		List<Quote> listQuote = new ArrayList<Quote>();
				
		assertEquals(quoteRepositoryMock.findQuotebySymbol("HELLO"),listQuote);
	}
	
	@Test 
	public void testFindSymbolByDayMostAsk() {
		

		List<Quote> listQuote = new ArrayList<Quote>();
		Date date = stringToDate("2024-04-20");
		
		
		assertEquals(quoteRepositoryMock.findSymbolbyDayMostAsk(date),listQuote);
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
