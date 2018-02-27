package com.kbaez.callcenter;

public class Director extends Employee {

	public Director(Dispatcher dispatcher, String name) {
		super(dispatcher, name);
		this.roleEmployee = Role.DIRECTOR;
	}
	
	@Override
	void addEmployeeAvailable(Dispatcher dispatcher){
		dispatcher.addEmpleadoDisponible(new Director(dispatcher, name));
	}

}
