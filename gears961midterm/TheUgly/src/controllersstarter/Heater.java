package controllersstarter;

public class Heater extends TempControlDevice {
	public final static double initTemp = 25;

	public Heater() {
		super(new Temperature(initTemp));
	}

	@Override
	public void timeTick() {
		this.adjustTemp(0.05);
	}

	@Override
	public String toString() {
		String status = this.isOn() ? "On" : "Off";
		return String.format("Heater: %s. Current temperature %s",
				status, this.getCurrentTemp());

	}
}
