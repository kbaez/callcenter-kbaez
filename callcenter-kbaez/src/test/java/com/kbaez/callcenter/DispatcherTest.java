package com.kbaez.callcenter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DispatcherTest extends TestCase {
	final int TIME_MAX = 10000;
 
    public static Test suite(){
        return new TestSuite( DispatcherTest.class );
    }
    
    public void testTenCalls(){
		System.out.println("----Test for 10 calls--------"); 
    	try {
    		
	    	Dispatcher dispatcher = new Dispatcher();
	    	new Thread(dispatcher).start();
	    	
			dispatcher.addEmpleadoDisponible(new Director(dispatcher, "Director 1 : Juan Diaz"));
			dispatcher.addEmpleadoDisponible(new Supervisor(dispatcher, "Supervisor 1 : Gabriel Perez"));
			dispatcher.addEmpleadoDisponible(new Operator(dispatcher, "Operator 1 : Martin Fernandez"));
			
	    	dispatcher.dispatchCall(new Call(" 1 - Lima/Perú "));
			dispatcher.dispatchCall(new Call(" 2 - Madrid/España"));
			dispatcher.dispatchCall(new Call(" 3 - Medellin/Colombia"));
			dispatcher.dispatchCall(new Call(" 4 - Okinawa/Japón"));
			dispatcher.dispatchCall(new Call(" 5 - Miami/USA"));
			dispatcher.dispatchCall(new Call(" 6 - Auckland/Nueva Zelanda"));
			dispatcher.dispatchCall(new Call(" 7 - Londres/Inglaterra"));
			dispatcher.dispatchCall(new Call(" 8 - Montevideo/Uruguay"));
			dispatcher.dispatchCall(new Call(" 9 - Santiago de Chile/Chile"));
			dispatcher.dispatchCall(new Call(" 10 - Ottawa/Canadá"));

			Thread.sleep((TIME_MAX * 10)/3);
			
			//comprobación que todas las llamadas fueron atendidas
			assertTrue(dispatcher.getLlamadas().isEmpty());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			fail();
		}
    	
    }
    
   public void testMoreTenCalls(){
	   System.out.println("----Test for more 10 calls--------"); 
    	try {
	    	Dispatcher dispatcher = new Dispatcher();
	    	new Thread(dispatcher).start();
	    	dispatcher.dispatchCall(new Call(" 1 - Lima/Perú "));
			dispatcher.dispatchCall(new Call(" 2 - Madrid/España"));
			dispatcher.dispatchCall(new Call(" 3 - Medellin/Colombia"));
			dispatcher.dispatchCall(new Call(" 4 - Okinawa/Japón"));
			dispatcher.dispatchCall(new Call(" 5 - Miami/USA"));
			dispatcher.addEmpleadoDisponible(new Operator(dispatcher, "Operator 1 : "));
			dispatcher.addEmpleadoDisponible(new Operator(dispatcher, "Operator 2 :"));
			dispatcher.addEmpleadoDisponible(new Operator(dispatcher, "Operator 3 :"));
			dispatcher.addEmpleadoDisponible(new Supervisor(dispatcher, "Supervisor 1 : "));
			dispatcher.addEmpleadoDisponible(new Operator(dispatcher, "Operator 4 : "));
			dispatcher.dispatchCall(new Call(" 6 - Auckland/Nueva Zelanda"));
			dispatcher.addEmpleadoDisponible(new Director(dispatcher, "Director 1"));
			dispatcher.dispatchCall(new Call(" 7 - Londres/Inglaterra"));
			dispatcher.dispatchCall(new Call(" 8 - Montevideo/Uruguay"));
			dispatcher.addEmpleadoDisponible(new Supervisor(dispatcher, "Supervisor 2"));
			dispatcher.dispatchCall(new Call(" 9 - Santiago de Chile/Chile"));
			dispatcher.dispatchCall(new Call(" 10 - Ottawa/Canadá"));
			dispatcher.dispatchCall(new Call(" 11 - Brasilia/Brasil"));
			dispatcher.dispatchCall(new Call(" 12 - Toronto/Canadá"));
			dispatcher.addEmpleadoDisponible(new Director(dispatcher, "Director 2"));
			dispatcher.dispatchCall(new Call(" 13 - Valparaiso/Chile"));
			dispatcher.dispatchCall(new Call(" 14 - Barcelona/España"));
			dispatcher.dispatchCall(new Call(" 15 - Bogotá/Colombia"));
			dispatcher.dispatchCall(new Call(" 16 - Tokyo/Japón"));

			Thread.sleep((TIME_MAX * 16)/8);
			
			//comprobación que todas las llamadas fueron atendidas
			assertTrue(dispatcher.getLlamadas().isEmpty());

		} catch (InterruptedException e) {
			e.printStackTrace();
			fail();
		}
    	
    }
}
