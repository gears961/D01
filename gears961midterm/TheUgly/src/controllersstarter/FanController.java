package controllersstarter;

public class FanController extends Controller {
	
	public static final double epsilon = 0.1;
	private Fan.Speed targetSpeed;
	private Double targetDirection;
	private Fan fan;

	public FanController(Fan fan) {
		super(fan);
		this.fan = fan;
		targetDirection = null;
		targetSpeed = null;
	}


	public Fan.Speed getTargetSpeed() {
		return targetSpeed;
	}

	public void setTargetSpeed(Fan.Speed targetSpeed) {
		this.targetSpeed = targetSpeed;
	}

	public double getTargetDirection() {
		return targetDirection;
	}

	public void setTargetDirection(double targetDirection) {
		this.targetDirection = targetDirection;
	}


	@Override
	public void control() {
		if (fan != null && fan.isOn()) {
			if (!fan.getSpeed().equals(targetSpeed)) {
				fan.adjustSpeed(targetSpeed);
			}
			if (!fan.getDirection().equals(targetDirection)) {
				fan.turn(targetDirection - fan.getDirection());
			}
		}
	}

	@Override
	public String toString() {
		if (fan != null) {
			String direction = (targetDirection == null) ? "not set" : targetDirection.toString();
			String speed = (targetSpeed == null) ? "not set" : targetSpeed.toString();
			return String.format("Controller for %s. Target direction: %s. Target speed: %s.",
					fan.toString(), direction, speed);
		}
		return String.format("");
	}
}