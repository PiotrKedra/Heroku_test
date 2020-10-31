package heroku_test.heroku_test.project.api;

import heroku_test.heroku_test.project.api.dto.ProjectDTO;
import heroku_test.heroku_test.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProjectApi {

    private final ProjectService projectService;

    @Autowired
    public ProjectApi(ProjectService projectService) {
        this.projectService = projectService;
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

    public List<ProjectDTO> getTrendyProjects(){
        return projectService.getTrendyProjects();
    }
}
