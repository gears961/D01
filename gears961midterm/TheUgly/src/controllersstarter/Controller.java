package controllersstarter;

public abstract class Controller {

	private Device device;

	public Controller(Device device) {
		this.device = device;
	}

	public void turnOn() {
		device.setIsOn(true);
	}

	public void turnOff() {
		device.setIsOn(false);
	}

	public abstract void control();

	@Override
	public String toString() {
		return String.format("Controller for ??");
	}

}