package heroku_test.heroku_test.project.api.dao;

import heroku_test.heroku_test.project.api.dao.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {

    Iterable<ProjectEntity> getTop3();
}
