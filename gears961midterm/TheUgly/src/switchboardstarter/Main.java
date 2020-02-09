package switchboardstarter;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Controller fanController = new Controller(new Fan());
		fanController.setTargetDirection(90.0);
		fanController.setTargetSpeed(Fan.Speed.HIGH);
		fanController.turnOn();
		fanController.control();
		
		Controller heaterController = new Controller(new Heater());
		heaterController.setTargetTemp(new Temperature(26.0));
		heaterController.turnOn();
		heaterController.control();
		
		Controller refrigeratorController = new Controller(new Refrigerator());
		refrigeratorController.setTargetTemp(new Temperature(4.0));
		refrigeratorController.turnOn();
		refrigeratorController.control();
		System.out.println("\n\n\n");

		SwitchBoard switchBoard = new SwitchBoard(Arrays.asList(
				new Controller[] {fanController, 
						          heaterController, 
						          refrigeratorController}));
		int printUpTo = 10;

		for (Controller controller: switchBoard) {
			if (printUpTo > 0) {
				System.out.println(controller);
				printUpTo--;
			} else {
				break;
			}
		}
	}
	/* OUTPUT
Controller for Fan: On. Direction 90.00 degrees. Speed HIGH. Target direction 90.0. Target speed HIGH.
Controller for Heater: On. Current temperature 25.90 degrees. Target temperature 26.00 degrees.
Controller for Refrigerator: On. Current temperature 4.05 degrees. Door is closed. Light is off. Target temperature 4.00 degrees.
Controller for Fan: On. Direction 90.00 degrees. Speed HIGH. Target direction 90.0. Target speed HIGH.
Controller for Heater: On. Current temperature 25.90 degrees. Target temperature 26.00 degrees.
Controller for Refrigerator: On. Current temperature 4.05 degrees. Door is closed. Light is off. Target temperature 4.00 degrees.
Controller for Fan: On. Direction 90.00 degrees. Speed HIGH. Target direction 90.0. Target speed HIGH.
Controller for Heater: On. Current temperature 25.90 degrees. Target temperature 26.00 degrees.
Controller for Refrigerator: On. Current temperature 4.05 degrees. Door is closed. Light is off. Target temperature 4.00 degrees.
Controller for Fan: On. Direction 90.00 degrees. Speed HIGH. Target direction 90.0. Target speed HIGH.
	 */
}