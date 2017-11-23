package be.juvo.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RobotNotFoundException extends RuntimeException {
    public RobotNotFoundException(String identifier) {
        super("Could not find Robot " + identifier + ".");
    }
}
