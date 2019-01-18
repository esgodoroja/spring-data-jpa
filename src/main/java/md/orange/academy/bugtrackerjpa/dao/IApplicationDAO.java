package md.orange.academy.bugtrackerjpa.dao;

import md.orange.academy.bugtrackerjpa.entity.Application;

public interface IApplicationDAO {
    void addApplication(Application application);
    boolean applicationExists(String name, String owner);
    Application getApplicationById(int applicationId);
    void updateApplication(Application application);
    void deleteApplication(int applicationId);
}
