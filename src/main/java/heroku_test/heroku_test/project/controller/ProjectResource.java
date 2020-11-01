package heroku_test.heroku_test.project.controller;

import heroku_test.heroku_test.project.api.ProjectApi;
import heroku_test.heroku_test.project.api.dto.ProjectDTO;
import heroku_test.heroku_test.project.api.ex.ProjectNotFoudExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

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

    @PostMapping(consumes = "application/octet-stream")
    @ResponseBody
    public Long create(@RequestPart("project") ProjectDTO project, @RequestPart("project_img")MultipartFile projectImg) {
        System.out.println(project);
        System.out.println(Objects.nonNull(projectImg));
//        return projectApi.create(project);
        return 12L;
    }

    @GetMapping(PROJECT_ID_MAPPING)
    public ProjectDTO get(@PathVariable(name = PROJECT_ID) Long id) {
        return projectApi.get(id).orElseThrow(ProjectNotFoudExcpetion::new);
    }

    @GetMapping(TRENDY_PROJECTS)
    public List<ProjectDTO> getTrendy(){
        return projectApi.getTrendyProjects();
    }

//    @PostMapping
//    private ResponseEntity<Long> saveProjectImage(@RequestParam("imageFile") MultipartFile file){
//        Long id = projectImageService.creatProjectImage(file);
//        return ResponseEntity.ok(id);
//    }
}

