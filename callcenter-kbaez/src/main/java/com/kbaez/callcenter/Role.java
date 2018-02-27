package com.kbaez.callcenter;

public enum Role {
	OPERATOR(1),
	SUPERVISOR(2),
	DIRECTOR(3);
	private int priority;
	
	Role(int priority){
		this.priority=priority;
	}
	
	public int getPriority(){
		return priority;
	}
}
