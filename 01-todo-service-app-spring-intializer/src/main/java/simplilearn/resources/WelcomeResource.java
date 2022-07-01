package simplilearn.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeResource {

	@GetMapping(path = "/")
	public String helloWorld() {
		return "Hello World!";
	}
}
