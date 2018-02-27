package com.kbaez.callcenter;

import java.util.Random;

public class Call {
	private int duration;
	private String description;
	public static final int MIN_DURATION = 5;
	public static final int MAX_DURATION = 10;

	public Call(String description){
		duration = new Random().nextInt(MAX_DURATION - MIN_DURATION + 1) + MIN_DURATION;
		this.description = description;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuracion(int duracion) {
		this.duration = duracion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
