package com.newer.ckw;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

@Mapper
public interface CustomerDao {
	
	//传入数据
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into customers(name,area,principal,level) values (#{name},#{area},#{principal},#{level})")
	boolean save(Customer customer);
	
	//查询所有数据
	@SelectProvider(type = inner.class, method = "sqlSelect")
	@Results(
			id = "",
			value = {
					@Result(column = "name", property = "name"),
					@Result(column = "area", property = "area"),
					@Result(column = "principal", property = "principal"),
					@Result(column = "level", property = "level"),
			})
	List<Customer> findALL(Customer customer);
	
	
	// 定义内部类
	static class inner{
		// 定义动态SQL方法
		public String sqlSelect(Customer customer) {
			return new SQL() {{
				SELECT("*");
				FROM("customers");
				if(customer != null) {
					if(customer.getName() != null && customer.getName().length() >0) {
						WHERE("name like concat('%',#{name},'%')");
					}
					if(customer.getArea() != null && customer.getArea().length() >0) {
						WHERE("area like concat('%',#{area},'%')");
					}
					if(customer.getPrincipal() != null && customer.getPrincipal().length() >0) {
						WHERE("principal like concat('%',#{principal},'%')");
					}
					if(customer.getLevel() != null && customer.getLevel().length() >0) {
						WHERE("level like concat('%',#{level},'%')");
					}
				}
			}}.toString();
		}
	}
}
