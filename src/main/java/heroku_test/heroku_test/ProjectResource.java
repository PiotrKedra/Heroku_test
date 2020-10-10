package heroku_test.heroku_test;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("projects")
public class ProjectResource {

    private final ProjectRepo projectRepo;
    private final SessionFactory sessionFactory;

    @Autowired
    public ProjectResource(ProjectRepo projectRepo, SessionFactory sessionFactory) {
        this.projectRepo = projectRepo;
        this.sessionFactory = sessionFactory;
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
    private ResponseEntity<Long> create(@RequestBody ProjectDTO project){
        Blob blob = getImageBlob(project);
        Project p = new Project(project.getName(), project.getAddDate(), blob);
        Project saved = projectRepo.save(p);
        return ResponseEntity.ok(saved.getId());
    }

    private Blob getImageBlob(@RequestBody ProjectDTO project) {
        try {
            byte[] byteData = project.getImage().getBytes("UTF-8");//Better to specify encoding
            Blob blobData = sessionFactory.getCurrentSession().getLobHelper().createBlob(byteData);
            blobData.setBytes(1, byteData);
            return blobData;
        } catch (SQLException | UnsupportedEncodingException e) {
            return null;
        }
    }
}
