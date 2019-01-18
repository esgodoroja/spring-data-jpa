package md.orange.academy.bugtrackerjpa.service;

import java.util.List;
import md.orange.academy.bugtrackerjpa.entity.Ticket;

public interface ITicketService {
    List getAllTickets();
    Ticket getTicketById(int ticketId);
    void addTicket(Ticket ticket);
    void updateTicket(Ticket ticket);
    void deleteTicket(int ticketId);
    void closeTicket(int ticketId);
}
