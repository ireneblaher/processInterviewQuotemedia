/**
 * 
 */
package com.quotemedia.interview.quoteservice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 */
@SuppressWarnings("serial")
@Embeddable
public class QuoteId implements Serializable{
	
	@Column(name="SYMBOL")
	private String symbol;
	
	
	@Column(name="DAY")
	private Date day;


	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}


	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	/**
	 * @return the day
	 */
	public Date getDay() {
		return day;
	}


	/**
	 * @param day the day to set
	 */
	public void setDay(Date day) {
		this.day = day;
	}
	
	

}
