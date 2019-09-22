package cn.xhf.service;

import cn.xhf.model.User;

public interface UserService extends BaseService<User>{

	User findUser(User user);

}
