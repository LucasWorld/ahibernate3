package com.lucas.hibernate.bean.chapter7.UnidirectionalAssociationsWithJoinTables.many2many;

import java.util.Set;

public class Person {
	private int personid;
	private Set<Address> addresses;

	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
