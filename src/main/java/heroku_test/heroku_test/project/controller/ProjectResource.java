package heroku_test.heroku_test.project.controller;

import heroku_test.heroku_test.project.api.ProjectApi;
import heroku_test.heroku_test.project.api.dto.ProjectDTO;
import heroku_test.heroku_test.project.service.dao.ProjectEntity;
import heroku_test.heroku_test.project.api.ex.ProjectNotFoudExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static heroku_test.heroku_test.project.controller.ProjectsUrls.*;

@RestController
@CrossOrigin
@RequestMapping(PROJECTS_ROOT)
public class ProjectResource {

    private final ProjectApi projectApi;

    @Autowired
    public ProjectResource(ProjectApi projectApi) {
        this.projectApi = projectApi;
    }

    @GetMapping
    public String test() {
        return projectApi.test();
    }

    @PostMapping
    public Long create(@RequestBody ProjectDTO project) {
        return projectApi.create(project);
    }

    @GetMapping(PROJECT_ID_MAPPING)
    public ProjectDTO get(@PathVariable(name = PROJECT_ID) Long id) {
        return projectApi.get(id).orElseThrow(ProjectNotFoudExcpetion::new);
    }

    @GetMapping(TRENDY_PROJECTS)
    public Iterable<ProjectEntity> getTrendy(){
        return projectApi.getTrendyProjects();
    }

//    @PostMapping
//    private ResponseEntity<Long> saveProjectImage(@RequestParam("imageFile") MultipartFile file){
//        Long id = projectImageService.creatProjectImage(file);
//        return ResponseEntity.ok(id);
//    }
}

