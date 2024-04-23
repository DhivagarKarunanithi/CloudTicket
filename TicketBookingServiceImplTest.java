package com.train.booking.service.impl;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.train.booking.dao.TicketBookingRepository;
import com.train.booking.model.Ticket;

public class TicketBookingServiceImplTest {
	
	@InjectMocks
	private TicketBookingServiceImpl ticketBookingService;

	@Mock
	private TicketBookingRepository ticketBookingRepository;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 *  Test case for getTicketById 
	 */
	@Test
	public void getTicketByIdTest() {
		Ticket ticket = Mockito.mock(Ticket.class);
		Mockito.when(ticketBookingRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(ticket));
		Ticket tick = ticketBookingService.getTicketById(1);
		assertNotNull(tick);
		Mockito.verify(ticketBookingRepository, Mockito.times(1)).findById(Mockito.anyInt());
	}
	
	@Test
	public void getAllTicketsTest() {
		List<Ticket> ticketLists = new ArrayList<>();
		Ticket ticket = Mockito.mock(Ticket.class);
		ticketLists.add(ticket);
		Mockito.when(ticketBookingRepository.findAll()).thenReturn(ticketLists);
		List<Ticket> tickets = ticketBookingService.getAllTickets();
		assertNotNull(tickets);
		Mockito.verify(ticketBookingRepository, Mockito.times(1)).findAll();
	}
	
	@Test
	public void generateTicketTest() {
		Mockito.doNothing().when(ticketBookingRepository).deleteById(Mockito.anyInt());
		ticketBookingService.deleteTicketById(1);
		Mockito.verify(ticketBookingRepository, Mockito.times(1)).deleteById(Mockito.anyInt());
		
	}
}
