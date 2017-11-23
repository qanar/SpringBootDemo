package be.juvo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/robots")
public class RobotController {
    @Autowired
    private RobotRepository robotRepository;

    @RequestMapping
    public List<Robot> findAll(@RequestParam(required = false) Boolean lethal) {
        if (lethal == null) {
            return robotRepository.findAll();
        } else {
            return robotRepository.findByLethal(lethal);
        }
    }

    @RequestMapping("/{id}")
    public Robot findOne(@PathVariable String id) {
        Robot robot = robotRepository.findOne(id);
        if (robot == null) {
            throw new RobotNotFoundException(id);
        }
        return robot;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Robot create(@RequestBody Robot robot) {
        return robotRepository.insert(robot);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        robotRepository.delete(id);
    }
}
