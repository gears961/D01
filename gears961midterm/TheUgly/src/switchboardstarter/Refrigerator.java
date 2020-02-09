package switchboardstarter;

public class Refrigerator {
	public final static double initTemp = 6;

	private Boolean isOn;
	private Temperature currentTemp;
	private Boolean lightIsOn;
	private Boolean doorOpen;

	public Refrigerator() {
		isOn = false;
		currentTemp = new Temperature(initTemp);
		lightIsOn = false;
		doorOpen = false;
	}

	public Boolean isOn() {
		return isOn;
	}

	public void setIsOn(Boolean isOn) {
		this.isOn = isOn;
		if (!isOn) {
			currentTemp = new Temperature(initTemp);
			lightIsOn = false;
			doorOpen = false;			
		}
	}

	public void timeTick() {
		currentTemp.adjust(-0.05); // cheating to simplify
	}

	public Boolean isLightIsOn() {
		return lightIsOn;
	}

	public void setLightOn(Boolean lightIsOn) {
		this.lightIsOn = lightIsOn;
	}

	public Temperature getCurrentTemp() {
		return currentTemp;
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
		String status = isOn ? "On" : "Off";
		String door = doorOpen ? "open" : "closed";
		String light = lightIsOn ? "on" : "off";
		return String.format("Refrigerator: %s. Current temperature %s. Door is %s. Light is %s",
				status, currentTemp, door, light);

	}
}