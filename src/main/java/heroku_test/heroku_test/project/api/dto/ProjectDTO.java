package heroku_test.heroku_test.project.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private Date addDate;
    private Long userId;
    private MultipartFile img;

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", addDate=" + addDate +
                ", userId=" + userId +
                ", img=" + img +
                '}';
    }
}
