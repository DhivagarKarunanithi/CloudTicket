package com.train.booking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.booking.dao.TicketBookingRepository;
import com.train.booking.model.Ticket;
import com.train.booking.service.TicketBookingService;
import com.train.booking.util.Constants;
import com.train.booking.util.Validations;

/**
 * Ticket Booking Service provider class
 */
@Service
public class TicketBookingServiceImpl implements TicketBookingService {

	@Autowired
	private TicketBookingRepository ticketBookingRepository;

	@Override
	public Ticket getTicketById(int ticketId) {
		return ticketBookingRepository.findById(ticketId).orElse(null);
	}
	
	public List<Ticket> getAllTickets() {
		return ticketBookingRepository.findAll();
	}

	public Ticket generateTicket(Ticket ticket) {
		Validations.isValidSection(ticket.getSeatSection());
		ticket.setPricePaid(Constants.TICKET_COST);
		return ticketBookingRepository.save(ticket);
	}

	@Override
	public String deleteTicketById(int ticketId) {
		ticketBookingRepository.deleteById(ticketId);
		return "ticket has been cancelled";
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		Ticket existingTicket = null;
		Optional<Ticket> optionalTicket = ticketBookingRepository.findById(ticket.getTicketId());
		if(optionalTicket.isPresent()) {
			existingTicket=optionalTicket.get();
			existingTicket.setFromStation(ticket.getFromStation());
			existingTicket.setToStation(ticket.getToStation());
			existingTicket.setPricePaid(ticket.getPricePaid());
			existingTicket.setUser(ticket.getUser());
			ticketBookingRepository.save(existingTicket);
		}else {
			return new Ticket();
		}
		return existingTicket;
	}

}
