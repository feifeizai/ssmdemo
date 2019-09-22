package cn.xhf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xhf.model.User;
import cn.xhf.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login")
	public String login(User user){
		
		User u = userService.findUser(user);
		
		System.out.println(u.toString());
		return "index";
	}

}
