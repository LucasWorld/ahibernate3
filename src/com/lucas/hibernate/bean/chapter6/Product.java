package com.lucas.hibernate.bean.chapter6;

import java.util.HashSet;
import java.util.Set;

public class Product {
	private String serialNumber;
	/*
	 * HibernateҪ��־û������ֶα�������Ϊ�ӿڡ�
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
