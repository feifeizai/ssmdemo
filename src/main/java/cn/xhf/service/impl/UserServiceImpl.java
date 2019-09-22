package cn.xhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xhf.mapper.UserMapper;
import cn.xhf.model.Customer;
import cn.xhf.model.User;
import cn.xhf.service.UserService;

@Service
public class UserServiceImpl  extends BaseServiceImpl<User>  implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUser(User user) {
		User u= userMapper.selectOne(user);
		System.out.println(u.toString());

		return u;
	}

}
