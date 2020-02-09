package controllersstarter;

public class Main {

	public static void main(String[] args) {


		FanController fanController = new FanController(new Fan());
		System.out.println(fanController);
		fanController.setTargetDirection(90.0);
		fanController.setTargetSpeed(Fan.Speed.HIGH);
		fanController.turnOn();
		System.out.println(fanController);
		fanController.control();
		System.out.println(fanController);
		fanController.turnOff();
		System.out.println();

		HeaterController heaterController =
				new HeaterController(new Heater());
		System.out.println(heaterController);
		heaterController.setTargetTemp(new Temperature(26.0));
		heaterController.turnOn();
		System.out.println(heaterController);
		heaterController.control();
		System.out.println(heaterController);
		heaterController.turnOff();
		System.out.println();
		
		RefrigeratorController refrigeratorController =
				new RefrigeratorController(new Refrigerator());
		System.out.println(refrigeratorController);
		refrigeratorController.setTargetTemp(new Temperature(4.0));
		refrigeratorController.turnOn();
		System.out.println(refrigeratorController);
		refrigeratorController.control();
		System.out.println(refrigeratorController);
		refrigeratorController.openDoor();
		System.out.println(refrigeratorController);
		refrigeratorController.closeDoor();
		System.out.println(refrigeratorController);
		refrigeratorController.turnOff();		
		System.out.println("\n\n\n");

		

		/* OUTPUT */
		/*
Controller for Fan: Off. Direction 0.00 degrees. Speed OFF. Target direction not set. Target speed not set.
Controller for Fan: On. Direction 0.00 degrees. Speed OFF. Target direction 90.0. Target speed HIGH.
Controller for Fan: On. Direction 90.00 degrees. Speed HIGH. Target direction 90.0. Target speed HIGH.

Controller for Heater: Off. Current temperature 25.00 degrees. Target temperature not set.
Controller for Heater: On. Current temperature 25.00 degrees. Target temperature 26.00 degrees.
Controller for Heater: On. Current temperature 25.90 degrees. Target temperature 26.00 degrees.

Controller for Refrigerator: Off. Current temperature 6.00 degrees. Door is closed. Light is off. Target temperature not set.
Controller for Refrigerator: On. Current temperature 6.00 degrees. Door is closed. Light is off. Target temperature 4.00 degrees.
Controller for Refrigerator: On. Current temperature 4.05 degrees. Door is closed. Light is off. Target temperature 4.00 degrees.
Controller for Refrigerator: On. Current temperature 4.05 degrees. Door is open. Light is on. Target temperature 4.00 degrees.
Controller for Refrigerator: On. Current temperature 4.05 degrees. Door is closed. Light is off. Target temperature 4.00 degrees.
		 */
	}
}
