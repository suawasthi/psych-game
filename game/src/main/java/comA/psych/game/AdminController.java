package comA.psych.game;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminService")
public class AdminController {
	
	@GetMapping("/")
	public String getUserAccount() {
		return "userAccount";
		
	}
	
	

}
