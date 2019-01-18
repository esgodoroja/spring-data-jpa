package md.orange.academy.bugtrackerjpa.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import md.orange.academy.bugtrackerjpa.entity.Ticket;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class TicketDAO implements ITicketDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List getAllTickets() {
        //note Ticket is the class name; not the table name; class name is case sensitive; use class field names - column names
        String query = "select t from Ticket t order by t.id desc";
        return entityManager.createQuery(query)
            .setMaxResults(20).getResultList();
    }

    @Override
    public void addTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Override
    public Ticket getTicketById(int ticketId) {
        return entityManager.find(Ticket.class, ticketId);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        Ticket ticket1 = getTicketById(ticket.getId());

        ticket1.setDescription(ticket.getDescription());
        ticket1.setApplication(ticket.getApplication());
        ticket1.setTitle(ticket.getTitle());

        entityManager.flush();
    }

    @Override
    public void deleteTicket(int ticketId) {
        entityManager.remove(getTicketById(ticketId));

    }

    @Override
    public void closeTicket(int ticketId) {
        Ticket ticket = getTicketById(ticketId);
        ticket.setStatus("Resolved");
    }
}
