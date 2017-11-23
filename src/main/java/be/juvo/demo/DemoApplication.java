package be.juvo.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	public RobotRepository robotRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    InitializingBean setupDatabase() {
        return () -> {
            robotRepository.save(new Robot("BB-8", 67, false));
            robotRepository.save(new Robot("K-2SO", 216, true));
            robotRepository.save(new Robot("R2-D2", 109, true));
            robotRepository.save(new Robot("C-3PO", 167, false));
        };
    }

//    @Bean
//    InitializingBean setupDatabase() {
//	    return new InitializingBean() {
//            @Override
//            public void afterPropertiesSet() throws Exception {
//            robotRepository.save(new Robot("BB-8", 67, false));
//            robotRepository.save(new Robot("K-2SO", 216, true));
//            robotRepository.save(new Robot("R2-D2", 109, true));
//            robotRepository.save(new Robot("C-3PO", 167, false));
//            }
//        };
//    }
}
