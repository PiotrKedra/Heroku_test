package heroku_test.heroku_test.project.service;

import heroku_test.heroku_test.project.api.dto.ProjectDTO;
import heroku_test.heroku_test.project.service.dao.ProjectEntity;
import heroku_test.heroku_test.project.service.dao.ProjectImageEntity;
import heroku_test.heroku_test.user.api.dao.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ProjectMapper {

    private final ProjectImageService projectImageService;

    @Autowired
    public ProjectMapper(ProjectImageService projectImageService) {
        this.projectImageService = projectImageService;
    }

    ProjectEntity mapToEntity(ProjectDTO dto, MultipartFile projectImg){
        // TODO: 31.10.2020 create builders
        ProjectEntity entity = new ProjectEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setAddDate(dto.getAddDate());
        UserEntity userEntity = new UserEntity();
        userEntity.setId(dto.getUserId());
        entity.setUser(userEntity);
        ProjectImageEntity projectImageEntity = projectImageService.getCompressedImageEntity(projectImg);
        entity.setProjectImage(projectImageEntity);
        return entity;
    }

    ProjectDTO mapToDto(ProjectEntity entity){
        return ProjectDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .addDate(entity.getAddDate())
                .userId(entity.getUser().getId())
                .img(projectImageService.getDecompressedImageEntity(entity.getProjectImage()))
                .build();
    }
}
