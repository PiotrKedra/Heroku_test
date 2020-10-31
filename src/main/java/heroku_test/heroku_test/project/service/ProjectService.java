package heroku_test.heroku_test.project.service;

import heroku_test.heroku_test.project.api.dto.ProjectDTO;
import heroku_test.heroku_test.project.service.dao.ProjectEntity;
import heroku_test.heroku_test.project.service.dao.ProjectRepository;
import heroku_test.heroku_test.user.api.dao.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Long create(ProjectDTO projectDTO){
        ProjectEntity entity = mapToEntity(projectDTO);
        ProjectEntity created = projectRepository.save(entity);
        return created.getId();
    }

    private ProjectEntity mapToEntity(ProjectDTO dto){
        // TODO: 31.10.2020 create builders
        ProjectEntity entity = new ProjectEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setAddDate(dto.getAddDate());
        UserEntity userEntity = new UserEntity();
        userEntity.setId(dto.getUserId());
        entity.setUser(userEntity);
        return entity;
    }
}
