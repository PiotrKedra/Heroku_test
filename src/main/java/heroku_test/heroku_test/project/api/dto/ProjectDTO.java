package heroku_test.heroku_test.project.api.dto;

import lombok.Getter;

import java.sql.Date;

@Getter
public class ProjectDTO {
    private String name;
    private String description;
    private Date addDate;
    private Long userId;
}
