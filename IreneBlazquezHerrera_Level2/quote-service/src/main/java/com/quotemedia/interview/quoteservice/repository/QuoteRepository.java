/**
 * 
 */
package com.quotemedia.interview.quoteservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quotemedia.interview.quoteservice.model.Quote;
import com.quotemedia.interview.quoteservice.model.QuoteId;

/**
 * Repository class
 */
@Repository
public interface QuoteRepository extends JpaRepository<Quote, QuoteId>{
		
	//Get the quotes by Symbol
	@Query("SELECT q FROM Quote q WHERE q.quoteId.symbol = :symbol ORDER BY q.quoteId.day DESC")
	List<Quote> findQuotebySymbol(String symbol);
	
	//Get most used symbol by Day
	@Query("SELECT q FROM Quote q WHERE q.quoteId.day = :date ORDER BY q.ask DESC")
	List<Quote> findSymbolbyDayMostAsk(Date date);
	
}
