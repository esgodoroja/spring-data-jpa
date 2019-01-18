package md.orange.academy.bugtrackerjpa.dao;

import md.orange.academy.bugtrackerjpa.entity.Release;

public interface IReleaseDAO {
    void addRelease(Release release);
    void addApplication(Integer appId, Integer releaseId);
    Release getReleaseById(int releaseId);
}
