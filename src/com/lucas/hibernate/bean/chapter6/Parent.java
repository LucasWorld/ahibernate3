package com.lucas.hibernate.bean.chapter6;

import java.util.HashSet;
import java.util.Set;

public class Parent {
	private long id;
	private Set<Child> children = new HashSet<Child>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}

}
