package cn.xhf.service;

import java.util.List;

import cn.xhf.model.Customer;

public interface CustomerService extends BaseService<Customer>{

	List<Customer> getList();

	List<Customer> queryByTypeAndCustname(Customer customer);

	int add(Customer customer);

	int delete(Long cid);

}
