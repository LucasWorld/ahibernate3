package com.lucas.hibernate.bean;

import java.util.Calendar;

public class BlogItem {
	public Long _id;
	public Calendar _datetime;
	public String _text;
	public String _title;
	public Blog _blog;
	
	
	public Long get_id() {
		return _id;
	}
	public void set_id(Long _id) {
		this._id = _id;
	}
	public Calendar get_datetime() {
		return _datetime;
	}
	public void set_datetime(Calendar _datetime) {
		this._datetime = _datetime;
	}
	public String get_text() {
		return _text;
	}
	public void set_text(String _text) {
		this._text = _text;
	}
	public String get_title() {
		return _title;
	}
	public void set_title(String _title) {
		this._title = _title;
	}
	public Blog get_blog() {
		return _blog;
	}
	public void set_blog(Blog _blog) {
		this._blog = _blog;
	}
	@Override
	public String toString() {
		return "BlogItem [_id=" + _id + ", _datetime=" + _datetime + ", _text="
				+ _text + ", _title=" + _title + ", _blog=" + _blog + "]";
	}
	
	
}
