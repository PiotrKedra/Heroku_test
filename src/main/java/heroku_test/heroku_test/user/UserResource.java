package heroku_test.heroku_test.user;

import heroku_test.heroku_test.user.dao.UserEntity;
import heroku_test.heroku_test.user.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("users")
public class UserResource {


    private final UserRepository userRepository;

    @Autowired

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody UserEntity user){
        UserEntity created = userRepository.save(user);
        return ResponseEntity.ok(created.getId());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserEntity> get(@PathVariable(name = "id") Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
