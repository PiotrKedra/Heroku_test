package heroku_test.heroku_test;

import heroku_test.heroku_test.project.dao.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<ProjectEntity, Long> {
}
