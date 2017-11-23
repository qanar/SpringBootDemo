package be.juvo.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RobotRepository extends MongoRepository<Robot, String> {
    List<Robot> findByLethal(boolean lethal);
}
