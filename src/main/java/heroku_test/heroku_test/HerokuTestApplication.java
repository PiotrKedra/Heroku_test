package heroku_test.heroku_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@SpringBootApplication
public class HerokuTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HerokuTestApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(BobRepository bobRepository){
        return args -> {
            bobRepository.save(new Bob("aws", "aws lambdas?"));
            bobRepository.save(new Bob("B.O.B", "Miłosz bob?"));
        };
    }
}

@RestController
class HelloWorld {

    private final BobRepository bobRepository;

    public HelloWorld(BobRepository bobRepository) {
        this.bobRepository = bobRepository;
    }

    @GetMapping("/")
    String hello() {
        return "Hello world";
    }

    @GetMapping("/bobs")
    Iterable<Bob> bobs(){
        return bobRepository.findAll();
    }
}

@Entity
class Bob {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String message;

    public Bob() {
    }

    public Bob(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


interface BobRepository extends CrudRepository<Bob, Long>{}
