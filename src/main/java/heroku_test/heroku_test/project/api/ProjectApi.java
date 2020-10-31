package heroku_test.heroku_test.project.api;

import heroku_test.heroku_test.project.api.dto.ProjectDTO;
import heroku_test.heroku_test.project.service.ProjectService;
import heroku_test.heroku_test.project.service.dao.ProjectRepository;
import heroku_test.heroku_test.project.service.dao.ProjectEntity;
import heroku_test.heroku_test.project.service.ProjectImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Component
public class ProjectApi {

    private final ProjectService projectService;
    private final ProjectRepository projectRepository;
    private final ProjectImageService imageService;

    @Autowired
    public ProjectApi(ProjectService projectService, ProjectRepository projectRepository, ProjectImageService imageService) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
        this.imageService = imageService;
    }

    public String test() {
        return "DUPA 12";
    }

    public Long create(ProjectDTO project) {
        return projectService.create(project);
    }

    public Optional<ProjectDTO> get(Long id) {
        return projectService.get(id);
    }

    public Iterable<ProjectEntity> getTrendyProjects(){
        return projectRepository.findAll();
    }

    private Long saveProjectImage(MultipartFile file) {
        return imageService.creatProjectImage(file);
    }

}
