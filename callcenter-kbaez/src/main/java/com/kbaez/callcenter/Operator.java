package com.kbaez.callcenter;

public class Operator extends Employee{

	public Operator(Dispatcher dispatcher, String name){
		super(dispatcher, name);
		super.roleEmployee = Role.OPERATOR;
	}
	
	@Override
	void addEmployeeAvailable(Dispatcher dispatcher) {
		dispatcher.addEmpleadoDisponible(new Operator(dispatcher, name));
	}
}
