package heroku_test.heroku_test;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Date addDate;

    @Lob
    @Column
    private String image;

    public Project() {
    }

    public Project(String name, Date addDate, String image) {
        this.name = name;
        this.addDate = addDate;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getAddDate() {
        return addDate;
    }

    public String getImage() {
        return image;
    }
}
