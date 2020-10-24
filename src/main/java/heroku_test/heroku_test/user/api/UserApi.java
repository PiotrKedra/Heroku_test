package heroku_test.heroku_test.user.api;

import heroku_test.heroku_test.user.api.dao.UserEntity;
import heroku_test.heroku_test.user.api.dao.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@AllArgsConstructor
public class UserApi {
    private final UserRepository userRepository;


    public Long create(UserEntity user) {
        UserEntity created = userRepository.save(user);
        return created.getId();
    }

    public Optional<UserEntity> get(Long id) {
        return userRepository.findById(id);
    }

}
