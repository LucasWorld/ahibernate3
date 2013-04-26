package com.lucas.hibernate.bean;

import java.util.List;

public class Blog {
	private Long _id;
	private String _name;
	private List _items;
	public Long get_id() {
		return _id;
	}
	public void set_id(Long _id) {
		this._id = _id;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public List get_items() {
		return _items;
	}
	public void set_items(List _items) {
		this._items = _items;
	}
	@Override
	public String toString() {
		return "Blog [_id=" + _id + ", _name=" + _name + ", _items=" + _items
				+ "]";
	}
	
	
}
