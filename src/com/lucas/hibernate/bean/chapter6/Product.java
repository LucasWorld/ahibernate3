package com.lucas.hibernate.bean.chapter6;

import java.util.HashSet;
import java.util.Set;

public class Product {
	private String serialNumber;
	/*
	 * Hibernate要求持久化集合字段必须声明为接口。
	 * **/
	private Set parts = new HashSet();

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Set getParts() {
		return parts;
	}

	public void setParts(Set parts) {
		this.parts = parts;
	}

}
