package heroku_test.heroku_test.project.api;

import heroku_test.heroku_test.ProjectRepository;
import heroku_test.heroku_test.project.api.dao.ProjectImageRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {

    @Bean
    ProjectApi projectApi(ProjectRepository projectRepository, ProjectImageRepository imageRepository) {
        return new ProjectApi(projectRepository, new ProjectImageService(imageRepository));
    }
}
