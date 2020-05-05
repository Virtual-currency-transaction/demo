package com.newer.ckw;

/**
 * 客户实体类
 * @author 24896
 *
 */
public class Customer {
	int id;
	
	String name;
	String area;
	String principal;
	String level;
	
	public Customer() {
	}

	// get set 方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	// toString
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", area=" + area + ", principal=" + principal + ", level="
				+ level + "]";
	}
	
	
}
