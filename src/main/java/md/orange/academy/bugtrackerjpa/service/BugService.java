package md.orange.academy.bugtrackerjpa.service;

import md.orange.academy.bugtrackerjpa.dao.BugDAO;
import md.orange.academy.bugtrackerjpa.entity.Bug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BugService implements IBugService {

    @Autowired
    private BugDAO bugDAO;

    @Override
    public void addBug(Bug bug) {
        bugDAO.addBug(bug);

    }
}
