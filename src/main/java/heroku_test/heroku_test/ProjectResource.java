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
    private ResponseEntity<Iterable<Project>> readAll(){
        Iterable<Project> allProjects = projectRepo.findAll();
        return ResponseEntity.ok(allProjects);
    }

    @GetMapping("{id}")
    private ResponseEntity<Project> read(@PathVariable("id") Long id){
        Optional<Project> project = projectRepo.findById(id);
        return project.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).build());
    }

    @PostMapping
    private ResponseEntity<Long> create(@RequestBody Project project){
        Project saved = projectRepo.save(project);
        return ResponseEntity.ok(saved.getId());
    }
}
