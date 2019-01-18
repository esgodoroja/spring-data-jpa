package md.orange.academy.bugtrackerjpa.service;

import java.util.Optional;
import md.orange.academy.bugtrackerjpa.entity.Application;

public interface IApplicationService {
    boolean addApplication(Application application);
    Application getApplicationById(int applicationId);
    void updateApplication(Application application);
    void deleteApplication(int applicationId);
    Optional<Application> getApplicationByName(String name);
}
