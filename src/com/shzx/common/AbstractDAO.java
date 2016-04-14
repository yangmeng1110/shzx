package com.shzx.common;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 根据单个条件查询对象
	 * @param sql
	 * @param param
	 * @return
	 */
	public Object findByProperty(String statement,Object parameter){
		return sqlSessionTemplate.selectOne(statement, parameter);
	}
	
	/**
	 * 根据单个条件查询列表
	 * @param sql
	 * @param map
	 * @return
	 */
	public List findListByProperty(String statement, Object parameter){
		List list = sqlSessionTemplate.selectList(statement, parameter);
		if(list != null && list.size() != 0){
			return list;
		}
		return null;
	}
	
	public int insert(String statement,Object parameter){
		return sqlSessionTemplate.insert(statement, parameter);
	}
	
	
	public int deleteByProperty(String statement,Object parameter){
		return sqlSessionTemplate.delete(statement, parameter);
	}
	
	
	public Long findCount(String statement,Object parameter){
		Long l = sqlSessionTemplate.selectOne(statement, parameter);
		if(l != null && l != 0){
			return l;
		}
		return null;
	}
	
	
	public int update(String statement,Object parameter){
		return sqlSessionTemplate.update(statement, parameter);
		
	}
}
