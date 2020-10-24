package heroku_test.heroku_test.project.controller;

import heroku_test.heroku_test.project.api.ProjectApi;
import heroku_test.heroku_test.project.api.dao.ProjectEntity;
import heroku_test.heroku_test.project.api.ex.ProjectNotFoudExcpetion;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("projects")
public class ProjectResource {

    private final ProjectApi projectApi;

    @GetMapping
    public String test() {
        return projectApi.test();
    }

    @PostMapping
    public Long create(@RequestBody ProjectEntity project) {
        return projectApi.create(project);
    }

    @GetMapping("{id}")
    public ProjectEntity get(@PathVariable(name = "id") Long id) {
        return projectApi.get(id).orElseThrow(ProjectNotFoudExcpetion::new);
    }

//    @PostMapping
//    private ResponseEntity<Long> saveProjectImage(@RequestParam("imageFile") MultipartFile file){
//        Long id = projectImageService.creatProjectImage(file);
//        return ResponseEntity.ok(id);
//    }
}

