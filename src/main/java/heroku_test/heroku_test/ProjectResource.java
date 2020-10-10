package heroku_test.heroku_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("projects")
public class ProjectResource {

    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectResource(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @GetMapping
    private ResponseEntity<Iterable<Project>> getAll(){
        Iterable<Project> allProjects = projectRepo.findAll();
        return ResponseEntity.ok(allProjects);
    }

    @GetMapping("/{id}")
    @ResponseBody
    private ResponseEntity<Project> get(@PathVariable("id") Long id){
        Optional<Project> project = projectRepo.findById(id);
        return project.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).build());
    }
}
