package heroku_test.heroku_test.project;

import heroku_test.heroku_test.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("projects")
public class ProjectResource {

    private final ProjectRepo projectRepo;
    private final ProjectImageService projectImageService;

    @Autowired
    public ProjectResource(ProjectRepo projectRepo, ProjectImageService projectImageService) {
        this.projectRepo = projectRepo;
        this.projectImageService = projectImageService;
    }

    @GetMapping
    private ResponseEntity<Message> test(){
        return ResponseEntity.ok(new Message("DUPA 12"));
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
