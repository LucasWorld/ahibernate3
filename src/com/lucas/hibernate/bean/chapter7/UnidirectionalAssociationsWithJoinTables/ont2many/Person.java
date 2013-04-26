package com.lucas.hibernate.bean.chapter7.UnidirectionalAssociationsWithJoinTables.ont2many;

import java.util.Set;

public class Person {
	private int personid;
	private Set<Address> address;



	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

}
