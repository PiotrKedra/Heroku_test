package heroku_test.heroku_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectResource {

    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectResource(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    private ResponseEntity<Iterable<Project>> getAll(){
        Iterable<Project> allProjects = projectRepo.findAll();
        return ResponseEntity.ok(allProjects);
    }
}
