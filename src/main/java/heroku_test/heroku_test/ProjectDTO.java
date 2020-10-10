package heroku_test.heroku_test;

import java.sql.Date;

public class ProjectDTO {

    private Long id;

    private String name;
    private Date addDate;
    private String image;

    public ProjectDTO() {
    }

    public ProjectDTO(Long id, String name, Date addDate, String image) {
        this.id = id;
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
