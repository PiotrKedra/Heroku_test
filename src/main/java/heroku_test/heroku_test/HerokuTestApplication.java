package heroku_test.heroku_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HerokuTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HerokuTestApplication.class, args);
    }

}


@RestController
class HelloWorld {

    @GetMapping("/")
    String hello() {
        return "Hello world";
    }

}
