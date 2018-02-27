package com.kbaez.callcenter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Employee extends Thread implements Comparable<Employee>{
		
		protected String name;
		private Call callAnswered;
		protected Role roleEmployee;
		private Dispatcher dispatcher;
		private static final Logger logger = LogManager.getLogger("Employee");
		
		public Employee(Dispatcher dispatcher, String name){
			this.dispatcher = dispatcher;
			this.name = name;
		}

		abstract void addEmployeeAvailable(Dispatcher dispatcher);
		
		public int getRolePriority(){
			return this.roleEmployee.getPriority();
		}

		public String getEmployeeName() {
			return name;
		}		
	
		public int compareTo(Employee e2) {
			if (this.getRolePriority() < e2.getRolePriority()){
				return -1;
			}
			if (this.getRolePriority() > e2.getRolePriority()){
				return 1;
			}
			return 0;	
		}
		
		/**
		 * It starts the thread when call is recived
		 * @param call to answer
		 * @throws InterruptedException
		 */
		public void takeCall(Call call) throws InterruptedException {
			this.callAnswered = call;
			this.start();
		}
		
		/**
		 * Represent the call process
		 */
		public void run() {
	        try {
			Thread.sleep(1000 * callAnswered.getDuration()); //execute call
	        System.out.println("Call " + callAnswered.getDescription() + " has been finalized. Duration :" + callAnswered.getDuration());
	        this.addEmployeeAvailable(dispatcher);
	        System.out.println("Employee " + this.getEmployeeName() + " available.");
			} catch (InterruptedException e) {
				System.out.println("Error taking call " + callAnswered.getDescription());
				logger.error("Error in call process", e);
				e.printStackTrace();
			} 
		}

}
