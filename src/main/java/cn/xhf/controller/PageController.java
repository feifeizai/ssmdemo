package cn.xhf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value="/page")
public class PageController {
	@RequestMapping(value="/{param}")
	public String page(@PathVariable(value="param")String param){
		return param;
	}
	
}
