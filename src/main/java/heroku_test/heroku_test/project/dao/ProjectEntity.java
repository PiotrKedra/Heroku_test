package heroku_test.heroku_test.project.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import heroku_test.heroku_test.user.dao.UserEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserEntity user;

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

    public UserEntity getUser() {
        return user;
    }

    public ProjectImageEntity getProjectImage() {
        return projectImage;
    }
}
