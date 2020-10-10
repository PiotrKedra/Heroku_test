package heroku_test.heroku_test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Blob;
import java.sql.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Date addDate;
    private Blob image;

    public Project() {
    }

    public Project(String name, Date addDate, Blob image) {
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

    public Blob getImage() {
        return image;
    }
}
