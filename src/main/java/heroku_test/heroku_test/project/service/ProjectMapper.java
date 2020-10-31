package heroku_test.heroku_test.project.service;

import heroku_test.heroku_test.project.api.dto.ProjectDTO;
import heroku_test.heroku_test.project.service.dao.ProjectEntity;
import heroku_test.heroku_test.user.api.dao.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    ProjectEntity mapToEntity(ProjectDTO dto){
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

    ProjectDTO mapToDto(ProjectEntity entity){
        return ProjectDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .addDate(entity.getAddDate())
                .userId(entity.getUser().getId())
                .build();
    }
}
