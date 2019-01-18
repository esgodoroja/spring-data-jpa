package md.orange.academy.bugtrackerjpa.dao;

import java.util.List;
import md.orange.academy.bugtrackerjpa.entity.Ticket;

public interface ITicketDAO {
    List getAllTickets();
    void addTicket(Ticket ticket);
    Ticket getTicketById(int ticketId);
    void updateTicket(Ticket ticket);
    void deleteTicket(int ticketId);
    void closeTicket(int ticketId);
}

