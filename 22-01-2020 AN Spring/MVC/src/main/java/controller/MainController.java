package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController (returns data [say home] instead of JSP)
@Controller
public class MainController {
	@RequestMapping("/home")
	public String add() {
		return "home";
	}
}
