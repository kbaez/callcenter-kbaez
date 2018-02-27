package com.kbaez.callcenter;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Manages incoming calls. 
 * @author Kari
 *
 */
public class Dispatcher implements Runnable {

	private static final Logger logger = LogManager.getLogger("Dispatcher");
	BlockingQueue<Employee> empleyeesAvailable;
	BlockingQueue<Call> calls; 
	
	public Dispatcher(){
		empleyeesAvailable = new PriorityBlockingQueue<Employee>();
		calls = new LinkedBlockingQueue<Call>();
	}

	public Queue<Call> getLlamadas(){
		return calls;
	}
	
	public Queue<Employee> getEmpleadosDisponibles(){
		return empleyeesAvailable;
	}

	public void run() {
		Call call;
		Employee employee;
		try {
			while(true){
				call = calls.take();
				logger.info("Waiting for taking a call " + call.getDescription());
				employee = empleyeesAvailable.take();
				logger.info("Employee " + employee.getName() + " will take the call " + call.getDescription());
				employee.takeCall(call);
			}
		} catch (InterruptedException e) {
			logger.error("Dispatcher - method Run", e);
			e.printStackTrace();
		}
		
	}
	
	public void dispatchCall(Call call) throws InterruptedException{
		System.out.println("Incoming call " + call.getDescription());
		this.calls.put(call);
	}

	public void addEmpleadoDisponible(Employee empleado){
		this.empleyeesAvailable.add(empleado);
	}
}
