package heroku_test.heroku_test.user.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "x_user")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String name;
    private String surname;
    private String password;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }
}
