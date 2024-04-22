package com.train.booking.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Ticket Entity 
 */
@Entity
public class Ticket {

	@Id
	@GeneratedValue
	private Integer ticketId;
	private String fromStation;
	private String toStation;
	private String pricePaid;
	private String seatSection;
	private int seatNumber;
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public String getPricePaid() {
		return pricePaid;
	}
	public void setPricePaid(String pricePaid) {
		this.pricePaid = pricePaid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSeatSection() {
		return seatSection;
	}
	public void setSeatSection(String seatSection) {
		this.seatSection = seatSection;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	
	

	

}
