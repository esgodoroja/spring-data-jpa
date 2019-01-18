package md.orange.academy.bugtrackerjpa.dao;

import java.util.Optional;
import md.orange.academy.bugtrackerjpa.entity.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IApplicationRepository
    extends CrudRepository<Application, Integer> {

//  Optional<Application> findByApplicationName(String appName);
  Optional<Application> findByName(String appName);

}
