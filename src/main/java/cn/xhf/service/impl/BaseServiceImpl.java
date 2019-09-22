package cn.xhf.service.impl;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseServiceImpl<T> {
	
	private Class clazz;
	
	/**
	 * @param mapper
	 */
	public BaseServiceImpl() {
		ParameterizedType type = (ParameterizedType) (this.getClass().getGenericSuperclass());
		clazz = (Class)type.getActualTypeArguments()[0];
	}

	/***
	 * 支持泛型注入
	 */
	@Autowired
	private Mapper<T> mapper;

	public int save(T t) {
		return mapper.insert(t);
	}

	public int saveSelective(T t) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(t);
	}

	public int delete(T t) {
		// TODO Auto-generated method stub
		return mapper.delete(t);
	}

	public int deleteById(Object t) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(t);
	}


	public int deleteByIds(List<Object> ids) {
		// TODO Auto-generated method stub
		Example example = new Example(clazz);
		Criteria criteria = example.createCriteria();
		
		//指定对应的ID
		String fieldname ="id";
				
		//Class所有的属性
		 Field[] fields = clazz.getDeclaredFields();
		 
		 for (Field field : fields) {
			//获取对应的注解
			Id annotation = field.getAnnotation(Id.class);
			
			if(annotation!=null){
				//如果注解不为空，说明是主键对应的属性
				fieldname = field.getName();
				System.out.println("fieldname:"+fieldname);
				break;
			}
		}
		
		//delete from tb_user where id in(1,23,434,4545)
		//编写删除条件，根据ID数组集合批量删除数据
		//criteria.andIn("id", ids);
		 criteria.andIn(fieldname, ids);
		
		return mapper.deleteByExample(example);
	}

	public T getOneById(Object id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	public T getOne(T t) {
		// TODO Auto-generated method stub
		return mapper.selectOne(t);
	}

	public int update(T t) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(t);
	}

	public int updateSelective(T t) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(t);
	}

	public List<T> getList() {
		return mapper.select(null);
	}

	public PageInfo<T> getPageList(int page, int size) {
		//设置分页信息
		PageHelper.startPage(page, size);
		
		//集合查询
		List<T> list = mapper.select(null);
		
		//创建分页对象
		PageInfo<T> pageInfo = new PageInfo<T>(list);
		return pageInfo;
	}

	

}
