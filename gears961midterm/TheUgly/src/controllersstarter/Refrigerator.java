package controllersstarter;

public class Refrigerator extends TempControlDevice {
	public final static double initTemp = 6;
	private boolean doorOpen;
	private boolean lightIsOn;

	public Refrigerator() {
		super(new Temperature(initTemp));
		lightIsOn = false;
		doorOpen = false;
	}

	public void timeTick() {
		this.adjustTemp(-0.05); // cheating to simplify
	}

	public Boolean isLightOn() {
		return lightIsOn;
	}

	public void setLightOn(Boolean lightIsOn) {
		this.lightIsOn = lightIsOn;
	}

	public Boolean isDoorOpen() {
		return doorOpen;
	}

	public void openDoor() {
		doorOpen = true;
		lightIsOn = true;
	}

	public void closeDoor() {
		doorOpen = false;
		lightIsOn = false;
	}

	@Override
	public String toString() {
		String status = this.isOn() ? "On" : "Off";
		String door = this.isDoorOpen() ? "open" : "closed";
		String light = this.isLightOn() ? "on" : "off";
		return String.format("Refrigerator: %s. Current temperature %s. Door is %s. Light is %s",
				status, this.getCurrentTemp(), door, light);

	}
}