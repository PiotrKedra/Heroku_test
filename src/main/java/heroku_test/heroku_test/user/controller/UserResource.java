package heroku_test.heroku_test.user.controller;

import heroku_test.heroku_test.user.api.UserApi;
import heroku_test.heroku_test.user.api.dao.UserEntity;
import heroku_test.heroku_test.user.api.ex.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static heroku_test.heroku_test.user.controller.UserUrls.*;

@RestController
@CrossOrigin
@RequestMapping(USERS_ROOT)
@AllArgsConstructor
public class UserResource {

    private final UserApi userApi;

    @PostMapping
    public Long create(@RequestBody UserEntity user) {
        return userApi.create(user);
    }

    @GetMapping(USERS_ID_MAPPING)
    public UserEntity get(@PathVariable(name = USERS_ID) Long id) {
        return userApi.get(id).orElseThrow(UserNotFoundException::new);
    }
}
