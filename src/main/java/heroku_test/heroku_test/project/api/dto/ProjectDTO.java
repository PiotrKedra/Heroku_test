package heroku_test.heroku_test.project.api.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Getter
@Builder
public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private Date addDate;
    private Long userId;
    private MultipartFile img;
}
