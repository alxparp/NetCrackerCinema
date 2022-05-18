package com.netcracker.cinema.dao;

import com.netcracker.cinema.model.Ticket;

import java.util.Date;
import java.util.List;

public interface TicketDao {

    List<Ticket> findAll();

    List<Ticket> getTicketsByCode(long code);

    Ticket getBySeanceAndPlace(long seanceId, long placeId);

    List<Ticket> getBySeance(long seanceId);

    Ticket get(long ticketId);

    void delete(long ticketId);

    long getCode();

    void deleteBlockForOneHour(long seanceId);

    void save(Ticket ticket);

    int soldTickets(long objId, Date startDate, Date endDate);
}
