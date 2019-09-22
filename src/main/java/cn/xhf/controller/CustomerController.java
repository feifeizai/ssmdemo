package cn.xhf.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xhf.model.Customer;
import cn.xhf.service.CustomerService;

@Controller
@RequestMapping(value="/center")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value="/customer",produces="text/html;charset=utf-8")
	public String queryByTypeAndCustname(@RequestParam(value="cust_username1",required=false)String cust_username,
			@RequestParam(value="cust_type1",required=false)String cust_type,Model model){
		
		//查询条件的回显数据
		model.addAttribute("cust_username1",cust_username );
		model.addAttribute("cust_type1", cust_type);
		
		Customer customer = new Customer();
		if(StringUtils.isNotBlank(cust_username)){
			customer.setCust_name(cust_username);
		}
		if(StringUtils.isNotBlank(cust_type)){
			customer.setCust_type(cust_type);
		}
		
		List<Customer> list = customerService.queryByTypeAndCustname(customer);
		for (Customer customer2 : list) {
			System.out.println(customer2.toString());
		}
		model.addAttribute("list", list);
		return "center";
	}
	
	@ResponseBody
	@RequestMapping(value="/customer/insert",method=RequestMethod.POST)
	public String update(Customer customer){
		int i = customerService.add(customer);
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="/customer/delete",method=RequestMethod.POST)
	public String delete(@RequestParam(value="id")Long cid){
		int i = customerService.delete(cid);
		return null;
	}

}
