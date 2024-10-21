/**
 * 
 */
package com.quotemedia.interview.quoteservice.model;

import org.springframework.stereotype.Component;

/**
 * Response Class for the service's returns
 */
@Component
public class Response {
	
	private double bid;
	
	private double ask;

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
