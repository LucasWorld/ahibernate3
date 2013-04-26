package com.lucas.hibernate.bean.chapter7.UnidirectionalAssociationsWithJoinTables.many2one;

import java.util.Set;

public class Address {
	private int addressid;

	private Set<Person> person;

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public Set<Person> getPerson() {
		return person;
	}

	public void setPerson(Set<Person> person) {
		this.person = person;
	}

}
