package controllersstarter;

public abstract class TempController extends Controller {

	private Temperature targetTemp;
	private TempControlDevice device;

	public TempController(TempControlDevice device) {
		super(device);
		this.device = device;
		targetTemp = null;
	}

	public Temperature getTargetTemp() {
		return targetTemp;
	}

	public void setTargetTemp(Temperature targetTemp) {
		this.targetTemp = targetTemp;
	}

	@Override
	public String toString() {
		if (device != null) {
			String temp = (targetTemp == null) ? "not set" : targetTemp.toString();
			return String.format("Controller for %s. Target temperature: %s.",
					device.toString(), temp);
		}
		return String.format("");
	}
}