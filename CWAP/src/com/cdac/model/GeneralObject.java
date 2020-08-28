package com.cdac.model;

import java.util.Random;

public class GeneralObject {
	int id;
	String name;
	String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int randomNumber(int min, int max) {
		Random rn = new Random();
		int range = max - min + 1;
		int randomNum = min + rn.nextInt(range);
		return (randomNum);
	}
}
