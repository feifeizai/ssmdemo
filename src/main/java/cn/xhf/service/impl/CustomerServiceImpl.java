package cn.xhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xhf.mapper.CustomerMapper;
import cn.xhf.model.Customer;
import cn.xhf.service.CustomerService;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<Customer> getList() {
		
		return customerMapper.select(null);
	}

	@Override
	public List<Customer> queryByTypeAndCustname(Customer customer) {
		List<Customer> list = customerMapper.select(customer);
		return list;
	}

	@Override
	public int add(Customer customer) {
		int i = customerMapper.insertSelective(customer);
		return i;
	}

	@Override
	public int delete(Long cid) {
		Customer customer = new Customer();
		customer.setCid(cid);
		int i = customerMapper.delete(customer);
		return i;
	}

}
