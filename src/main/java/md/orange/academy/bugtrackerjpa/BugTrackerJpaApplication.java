package md.orange.academy.bugtrackerjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("md.orange.academy")
public class BugTrackerJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerJpaApplication.class, args);
	}
}
