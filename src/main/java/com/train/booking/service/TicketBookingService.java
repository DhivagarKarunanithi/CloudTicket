package com.train.booking.service;

import java.util.List;

import com.train.booking.model.Ticket;

public interface TicketBookingService {
	
	public Ticket getTicketById(int ticketId);

	public List<Ticket> getAllTickets();

	public Ticket generateTicket(Ticket ticket);
	
	public Ticket updateTicket(Ticket ticket);
	
	public String deleteTicketById(int ticketId);

}
