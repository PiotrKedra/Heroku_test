package heroku_test.heroku_test.project.dao;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "project")
public class ProjectEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Date addDate;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getAddDate() {
        return addDate;
    }
}
