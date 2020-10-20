package heroku_test.heroku_test.project;

import heroku_test.heroku_test.ProjectRepository;
import heroku_test.heroku_test.project.dao.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("projects")
public class ProjectResource {

    private final ProjectRepository projectRepository;
    private final ProjectImageService projectImageService;

    @Autowired
    public ProjectResource(ProjectRepository projectRepository, ProjectImageService projectImageService) {
        this.projectRepository = projectRepository;
        this.projectImageService = projectImageService;
    }

    @GetMapping
    public ResponseEntity<Message> test(){
        return ResponseEntity.ok(new Message("DUPA 12"));
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody ProjectEntity project){
        ProjectEntity saved = projectRepository.save(project);
        return ResponseEntity.ok(saved.getId());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProjectEntity> get(@PathVariable(name = "id") Long id){
        Optional<ProjectEntity> project = projectRepository.findById(id);
        return project.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    private ResponseEntity<Long> saveProjectImage(@RequestParam("imageFile") MultipartFile file){
        Long id = projectImageService.creatProjectImage(file);
        return ResponseEntity.ok(id);
    }
}

class Message{
    private String message;

    public Message() {
    }

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
