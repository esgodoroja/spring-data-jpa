package md.orange.academy.bugtrackerjpa.service;

import md.orange.academy.bugtrackerjpa.dao.IReleaseDAO;
import md.orange.academy.bugtrackerjpa.entity.Release;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReleaseService implements IReleaseService {

    @Autowired
    private IReleaseDAO releaseDAO;

    @Override
    public void addRelease(Release release) {
        releaseDAO.addRelease(release);
    }

    @Override
    public void addApplication(Integer appId, Integer releaseId) {
        releaseDAO.addApplication(appId, releaseId);
    }
}
