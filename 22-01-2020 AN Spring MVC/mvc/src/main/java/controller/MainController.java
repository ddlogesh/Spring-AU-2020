package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/create")
	public String create() {
		return "create";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "update";
	}
}