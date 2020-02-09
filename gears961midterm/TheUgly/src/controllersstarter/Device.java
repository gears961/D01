package controllersstarter;

public abstract class Device {

	private boolean isOn;

	public Device() {
		this.isOn = false;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setIsOn(boolean on) {
		isOn = on;
	}

	@Override
	public String toString() {
		return "";
	}
}
