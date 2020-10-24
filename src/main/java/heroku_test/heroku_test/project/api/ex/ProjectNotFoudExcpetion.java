package heroku_test.heroku_test.project.api.ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProjectNotFoudExcpetion extends RuntimeException {

}
