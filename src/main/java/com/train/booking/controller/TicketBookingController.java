package com.train.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.train.booking.model.Ticket;
import com.train.booking.service.TicketBookingService;

/**
 * Ticket booking controller
 */
@RestController
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;
	
	/**
	 * 
	 * @param ticketId
	 * @return
	 */
	@GetMapping("/getTicketById/{ticketId}")
	public Ticket getTicketById(@PathVariable int ticketId) {
		return ticketBookingService.getTicketById(ticketId);
	}
	
	/**
	 * 
	 * @return List of tickets
	 */
	@GetMapping("/getAllTickets")
	public List<Ticket> getAllTickets() {
		return ticketBookingService.getAllTickets();
	}

	/**
	 * Create Ticket
	 * @param ticket
	 * @return
	 */
	@PostMapping(value = "/createTicket")
	public Ticket generateTicket(@RequestBody Ticket ticket) {
		return ticketBookingService.generateTicket(ticket);
	}

	/**
	 * 
	 * @param ticket
	 * @return
	 */
	@PutMapping(value = "/updateTicket")
	public Ticket updateTicket(@RequestBody Ticket ticket) {
		return ticketBookingService.updateTicket(ticket);
	}

	/**
	 * Cancel a ticket
	 * @param ticketId
	 * @return 
	 */
	@DeleteMapping(value = "/deleteTicket/{ticketId}")
	public String deleteTicketById(@PathVariable int ticketId) {
		return ticketBookingService.deleteTicketById(ticketId);
	}

}
