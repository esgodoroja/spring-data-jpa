package md.orange.academy.bugtrackerjpa.service;


import md.orange.academy.bugtrackerjpa.dao.EnhancementDAO;
import md.orange.academy.bugtrackerjpa.entity.Enhancement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnhancementService implements IEnhancementService {

    @Autowired
    private EnhancementDAO enhancementDAO;

    @Override
    public void addEnhancement(Enhancement enhancement){
        enhancementDAO.addEnhancement(enhancement);
    }

}
