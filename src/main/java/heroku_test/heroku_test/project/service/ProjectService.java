package heroku_test.heroku_test.project.service;

import heroku_test.heroku_test.project.api.dto.ProjectDTO;
import heroku_test.heroku_test.project.service.dao.ProjectEntity;
import heroku_test.heroku_test.project.service.dao.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    public Long create(ProjectDTO projectDTO){
        ProjectEntity entity = projectMapper.mapToEntity(projectDTO);
        ProjectEntity created = projectRepository.save(entity);
        return created.getId();
    }

    public Optional<ProjectDTO> get(Long id){
        return projectRepository.findById(id)
                .map(projectMapper::mapToDto);
    }

    public List<ProjectDTO> getTrendyProjects(){
        List<ProjectEntity> trendy = projectRepository.findTrendyProjects();
        return trendy.stream()
                .map(projectMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
