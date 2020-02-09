package controllers;

public class Main {

	public static void main(String[] args) {

		Controller fanController = new Controller(new Fan());
		System.out.println(fanController);
		fanController.setTargetDirection(90.0);
		fanController.setTargetSpeed(Fan.Speed.HIGH);
		fanController.turnOn();
		System.out.println(fanController);
		fanController.control();
		System.out.println(fanController);
		fanController.turnOff();
		System.out.println();
		
		Controller heaterController = new Controller(new Heater());
		System.out.println(heaterController);
		heaterController.setTargetTemp(new Temperature(26.0));
		heaterController.turnOn();
		System.out.println(heaterController);
		heaterController.control();
		System.out.println(heaterController);
		heaterController.turnOff();
		System.out.println();
		
		Controller refrigeratorController = new Controller(new Refrigerator());
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
	}
}