package heroku_test.heroku_test.project.dao;

import javax.persistence.*;

@Entity
@Table(name = "project_image")
public class ProjectImageEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String type;

    @Column(name="img_bytes", length = 1000)
    private byte[] imageBytes;

    public ProjectImageEntity() {
    }

    public ProjectImageEntity(String name, String type, byte[] imageBytes) {
        this.name = name;
        this.type = type;
        this.imageBytes = imageBytes;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }
}
