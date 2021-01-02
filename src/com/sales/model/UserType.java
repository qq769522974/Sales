package com.sales.model;

public enum UserType {
	 STUDENT("ѧ��", 0),CANTEEN("ʳ��", 1),ADMIN("��������Ա", 2);
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