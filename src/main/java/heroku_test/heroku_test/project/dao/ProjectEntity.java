package heroku_test.heroku_test.project.dao;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "project")
public class ProjectEntity {

    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private Long id;

    private String name;
    private String description;
    private Date addDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proj_img_id", referencedColumnName = "proj_img_id")
    private ProjectImageEntity projectImage;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getAddDate() {
        return addDate;
    }

    public ProjectImageEntity getProjectImage() {
        return projectImage;
    }
}
