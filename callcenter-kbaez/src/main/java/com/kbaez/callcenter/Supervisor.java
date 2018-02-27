package com.kbaez.callcenter;

public class Supervisor extends Employee{

	public Supervisor(Dispatcher dispatcher, String nombre) {
		super(dispatcher, nombre);
		super.roleEmployee = Role.SUPERVISOR;
	}

	@Override
	void addEmployeeAvailable(Dispatcher dispatcher){
		dispatcher.addEmpleadoDisponible(new Supervisor(dispatcher, name));
	}

}
