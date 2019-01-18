package md.orange.academy.bugtrackerjpa.service;

import md.orange.academy.bugtrackerjpa.entity.Release;

public interface IReleaseService {
    void addRelease(Release release);
    void addApplication(Integer appId, Integer releaseId);
}
