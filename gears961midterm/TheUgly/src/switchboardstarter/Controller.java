package switchboardstarter;

public class Controller {
	private Fan fan;
	private Heater heater;
	private Refrigerator refrigerator;
	private Double targetDirection;  // angle between 0 and 360
	private Fan.Speed targetSpeed;
	private Temperature targetTemp;

	public Controller(Fan fan) {
		this.fan = fan;
		targetDirection = null;
		targetSpeed = null;
	}

	public Controller(Heater heater) {
		this.heater = heater;
		targetTemp = null;
	}

	public Controller(Refrigerator refrigerator) {
		this.refrigerator = refrigerator;
		targetTemp = null;
	}

	public Double getTargetDirection() {
		return targetDirection;
	}

	public void setTargetDirection(Double targetDirection) {
		this.targetDirection = targetDirection;
	}

	public Fan.Speed getTargetSpeed() {
		return targetSpeed;
	}

	public void setTargetSpeed(Fan.Speed targetSpeed) {
		this.targetSpeed = targetSpeed;
	}

	public Temperature getTargetTemp() {
		return targetTemp;
	}

	public void setTargetTemp(Temperature targetTemp) {
		this.targetTemp = targetTemp;
	}

	public void openDoor() {
		if (refrigerator != null) {
			refrigerator.openDoor();
		}
	}

	public void closeDoor() {
		if (refrigerator != null) {
			refrigerator.closeDoor();
		}
	}

	public void turnOn() {
		if (fan != null) {
			fan.setIsOn(true);
		} else if (heater != null) {
			heater.setIsOn(true);
		} else {
			refrigerator.setIsOn(true);
		}
	}

	public void turnOff() {
		if (fan != null) {
			fan.setIsOn(false);
		} else if (heater != null) {
			heater.setIsOn(false);
		} else {
			refrigerator.setIsOn(false);
		}
	}

	public void control() {
		if (fan != null && fan.isOn()) {
			if (!fan.getSpeed().equals(targetSpeed)) {
				fan.adjustSpeed(targetSpeed);
			}
			if (!fan.getDirection().equals(targetDirection)) {
				fan.turn(targetDirection - fan.getDirection());
			}
		} else if (refrigerator != null && refrigerator.isOn()) {
			if (refrigerator.isDoorOpen()) {
				refrigerator.setLightOn(true);
			} else {
				refrigerator.setLightOn(false);
			}
			if (refrigerator.getCurrentTemp().compareTo(targetTemp) > 0) {
				while (!refrigerator.getCurrentTemp().equals(targetTemp))
					refrigerator.timeTick(); // cheating to simplify
			}
		} else {
			if (heater.isOn()) {
				if (heater.getCurrentTemp().compareTo(targetTemp) < 0) {
					while (!heater.getCurrentTemp().equals(targetTemp))
						heater.timeTick(); // cheating to simplify
				}
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
		if (heater != null) {
			String temp = (targetTemp == null) ? "not set" : targetTemp.toString();
			return String.format("Controller for %s. Target temperature: %s.",
					heater.toString(), temp); 
		}
		String temp = (targetTemp == null) ? "not set" : targetTemp.toString();
		return String.format("Controller for %s. Target temperature: %s.",
				refrigerator.toString(), temp); 
	}
}