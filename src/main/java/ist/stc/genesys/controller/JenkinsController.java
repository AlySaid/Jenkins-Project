package ist.stc.genesys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsController {
	@GetMapping("/jenkins")
	public String jenkins() {
		return "Welcome to jenkins course !!!    V 5";
	}
}
