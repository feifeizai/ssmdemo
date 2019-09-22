package cn.xhf.mapper;

import com.github.abel533.mapper.Mapper;

import cn.xhf.model.User;

public interface UserMapper extends Mapper<User>{

	User findUser(User user);

}
