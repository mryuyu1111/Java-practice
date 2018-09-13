package com.fdm.springMVCIntro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdm.Model.LoginManager;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@Controller
public class HomeController {

	@RequestMapping("/")
	public String homeHandler(Model DTO){
		DTO.addAttribute("user", new User());
		return "home";
	}

	@RequestMapping(value="/submit", method=POST)
	public String submitHandler(User user, Model DTO){
		LoginManager lm = new LoginManager();
		if(lm.allowLogin(user))
		{
			DTO.addAttribute("user",user);
		}
		else
		{
			DTO.addAttribute("user",new User());
		}
		return "view";
			
	}

}
