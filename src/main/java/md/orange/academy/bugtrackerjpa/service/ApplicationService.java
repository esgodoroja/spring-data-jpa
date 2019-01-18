package md.orange.academy.bugtrackerjpa.service;

import java.util.Optional;
import md.orange.academy.bugtrackerjpa.dao.IApplicationDAO;
import md.orange.academy.bugtrackerjpa.dao.IApplicationRepository;
import md.orange.academy.bugtrackerjpa.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService implements IApplicationService{

    @Autowired
    private IApplicationDAO applicationDAO;

    @Autowired
    private IApplicationRepository applicationRepository;

    @Override
    public synchronized boolean addApplication(Application application) {
        if (applicationDAO.applicationExists(application.getName(), application.getOwner())) {
            return false;
        } else{
            applicationDAO.addApplication(application);
            return true;
        }
    }

    @Override
    public Application getApplicationById(int applicationId) {
        return applicationDAO.getApplicationById(applicationId);
    }

    @Override
    public void updateApplication(Application application) {
        applicationDAO.updateApplication(application);

    }

    @Override
    public void deleteApplication(int applicationId) {
        applicationDAO.deleteApplication(applicationId);
    }

    @Override
    public Optional<Application> getApplicationByName(String name) {
        return applicationRepository.findByName(name);
    }
}
