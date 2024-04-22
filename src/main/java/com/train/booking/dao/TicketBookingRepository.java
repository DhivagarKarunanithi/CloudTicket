package com.train.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.train.booking.model.Ticket;

/**
 * Ticket Booking JPA repository 
 */
public interface TicketBookingRepository extends JpaRepository<Ticket, Integer> {

}
