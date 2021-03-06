package heroku_test.heroku_test.project.api.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private Date addDate;
    private Long userId;
    private byte[] img;

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", addDate=" + addDate +
                ", userId=" + userId +
                '}';
    }
}
