/**
 * 
 */
package com.quotemedia.interview.quoteservice.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Model Class
 */
@Entity
@Table(name="QUOTE")
public class Quote {

	@EmbeddedId
	private QuoteId quoteId;
	
	@Column(name="BID")
	private double bid;
	
	@Column(name="ASK")
	private double ask;
	
	

	/**
	 * @param quoteId
	 * @param bid
	 * @param ask
	 */
	public Quote(QuoteId quoteId, double bid, double ask) {
		this.quoteId = quoteId;
		this.bid = bid;
		this.ask = ask;
	}
	
	/**
	 * Default constructor
	 */
	public Quote(){}
	
	/**
	 * @return the quoteId
	 */
	public QuoteId getQuoteId() {
		return quoteId;
	}

	/**
	 * @param quoteId the quoteId to set
	 */
	public void setQuoteId(QuoteId quoteId) {
		this.quoteId = quoteId;
	}

	/**
	 * @return the bid
	 */
	public double getBid() {
		return bid;
	}

	/**
	 * @param bid the bid to set
	 */
	public void setBid(double bid) {
		this.bid = bid;
	}

	/**
	 * @return the ask
	 */
	public double getAsk() {
		return ask;
	}

	/**
	 * @param ask the ask to set
	 */
	public void setAsk(double ask) {
		this.ask = ask;
	}
	

}
