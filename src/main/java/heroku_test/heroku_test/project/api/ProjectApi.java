package heroku_test.heroku_test.project.api;

import heroku_test.heroku_test.ProjectRepository;
import heroku_test.heroku_test.project.api.dao.ProjectEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@AllArgsConstructor
public class ProjectApi {
    private final ProjectRepository projectRepository;
    private final ProjectImageService imageService;

    public String test() {
        return "DUPA 12";
    }

    public Long create(ProjectEntity project) {
        ProjectEntity saved = projectRepository.save(project);
        return saved.getId();
    }

    public Optional<ProjectEntity> get(Long id) {
        return projectRepository.findById(id);
    }

    private Long saveProjectImage(MultipartFile file) {
        return imageService.creatProjectImage(file);
    }

}
