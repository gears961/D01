package controllers;

public class Heater {
	public final static double initTemp = 25;

	private Boolean isOn;
	private Temperature currentTemp;

	public Heater() {
		isOn = false;
		currentTemp = new Temperature(initTemp);
	}
	
	public Boolean isOn() {
		return isOn;
	}

	public void setIsOn(Boolean isOn) {
		this.isOn = isOn;
		if (!isOn)
			currentTemp = new Temperature(initTemp);
	}

	public Temperature getCurrentTemp() {
		return currentTemp;
	}

	public void timeTick() {
		currentTemp.adjust(0.05);
	}

	@Override
	public String toString() {
		String status = isOn ? "On" : "Off";
		return String.format("Heater: %s. Current temperature %s",
				status, currentTemp);
	}
}