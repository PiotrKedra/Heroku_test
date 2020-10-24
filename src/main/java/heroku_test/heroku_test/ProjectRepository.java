package heroku_test.heroku_test;

import heroku_test.heroku_test.project.api.dao.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {
}
