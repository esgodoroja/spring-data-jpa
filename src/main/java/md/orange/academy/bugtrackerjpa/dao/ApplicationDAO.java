package md.orange.academy.bugtrackerjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import md.orange.academy.bugtrackerjpa.entity.Application;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class ApplicationDAO implements  IApplicationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addApplication(Application application) {
        entityManager.persist(application);
    }

    @Override
    public boolean applicationExists(String name, String owner) {
        //note application is the class name; not the table name; class name is case sensitive; use class field names - column names
        String jpql = "FROM Application as a "
            + "WHERE a.name = :name and a.owner = ?";
        int count = entityManager.createQuery(jpql)
            .setParameter("name", name)
            .setParameter(1, owner).setMaxResults(1)
            .getResultList().size();
        return count > 0;
    }

    @Override
    public Application getApplicationById(int applicationId) {
        return entityManager.find(Application.class, applicationId);
    }

    @Override
    public void updateApplication(Application application) {
        Application app = getApplicationById(application.getId());
        app.setName(application.getName());
        app.setDescription(application.getDescription());
        app.setOwner(application.getOwner());
        entityManager.flush();
    }

    @Override
    public void deleteApplication(int applicationId) {
        entityManager.remove(getApplicationById(applicationId));
    }

}
