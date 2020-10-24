package heroku_test.heroku_test.user.api;

import heroku_test.heroku_test.user.api.dao.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserApiConfig {
    @Bean
    UserApi userApi(UserRepository userRepository) {
        return new UserApi(userRepository);
    }
}
