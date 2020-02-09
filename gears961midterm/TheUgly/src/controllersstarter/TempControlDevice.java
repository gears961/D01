package controllersstarter;

public abstract class TempControlDevice extends Device {

	private Temperature currentTemp;

	public TempControlDevice(Temperature currentTemp) {
		this.currentTemp = currentTemp;
	}

	public Temperature getCurrentTemp() {
		return currentTemp;
	}

	public void adjustTemp(Double degrees) {
		currentTemp.adjust(degrees);
	}

	public abstract void timeTick();

	@Override
	public String toString() {
		return String.format("");
	}
}
