package md.orange.academy.bugtrackerjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import md.orange.academy.bugtrackerjpa.entity.Enhancement;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class EnhancementDAO implements IEnhancementDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addEnhancement(Enhancement enhancement) {
        entityManager.persist(enhancement);
    }
}
