package com.sales.model;

public enum UserType {
	 STUDENT("学生", 0),CANTEEN("食堂", 1),ADMIN("超级管理员", 2);
	private String name;
	private int index;

	private UserType(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return this.name;
	}
}