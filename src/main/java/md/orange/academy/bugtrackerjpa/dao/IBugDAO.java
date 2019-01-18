package md.orange.academy.bugtrackerjpa.dao;

import java.util.List;
import md.orange.academy.bugtrackerjpa.entity.Bug;

public interface IBugDAO {
    void addBug(Bug bug);

    List findBugBySeverity(int severityLevel);
}
