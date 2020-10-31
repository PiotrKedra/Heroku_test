package heroku_test.heroku_test.project.service.dao;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    default List<ProjectEntity> findTrendyProjects(){
        return findAll(PageRequest.of(0,3)).toList();
    }
}
