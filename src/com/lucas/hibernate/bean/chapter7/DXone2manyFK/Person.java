package com.lucas.hibernate.bean.chapter7.DXone2manyFK;

import java.util.Set;

public class Person {
	
	private int id;
	private Set<Address> address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}
}
