package heroku_test.heroku_test.user.api.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "x_user")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String email;
    private String name;
    private String surname;
    private String password;

}
