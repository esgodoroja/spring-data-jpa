package md.orange.academy.bugtrackerjpa.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import md.orange.academy.bugtrackerjpa.entity.Bug;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class BugDAO implements IBugDAO {

    private static final String QUERY_NAME = "";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBug(Bug bug) {
       entityManager.persist(bug);
    }

    @Override
    public List findBugBySeverity(int severityLevel) {
//        return entityManager
//            .createNamedQuery("Bug.findBugsBySeverity", Bug.class)
//            .setParameter("severity", severityLevel)
//            .getResultList();
        return entityManager
            .createNativeQuery("SELECT * FROM BUG "
                + "WHERE SEVERITY_LEVEL = :level", Bug.class)
            .setParameter("level", severityLevel)
            .getResultList();
    }
}
