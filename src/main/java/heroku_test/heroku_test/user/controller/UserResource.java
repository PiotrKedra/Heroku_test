package heroku_test.heroku_test.user.controller;

import heroku_test.heroku_test.user.api.UserApi;
import heroku_test.heroku_test.user.api.dao.UserEntity;
import heroku_test.heroku_test.user.api.ex.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("users")
@AllArgsConstructor
public class UserResource {

    private final UserApi userApi;

    @PostMapping
    public Long create(@RequestBody UserEntity user) {
        return userApi.create(user);
    }

    @GetMapping("{id}")
    public UserEntity get(@PathVariable(name = "id") Long id) {
        return userApi.get(id).orElseThrow(UserNotFoundException::new);
    }
}
