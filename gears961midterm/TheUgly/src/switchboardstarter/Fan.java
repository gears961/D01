package switchboardstarter;

public class Fan {

	public enum Speed {
		OFF, LOW, MEDIUM, HIGH; 
	}

	private Boolean isOn;
	private Double direction; // angle between 0 and 360
	private Speed speed;
	
	public Fan() {
		isOn = false;
		direction = 0.0;
		speed = Speed.OFF;
	}
	
	public Boolean isOn() {
		return isOn;
	}
	
	public void setIsOn(Boolean isOn) {
		this.isOn = isOn;
		if (!isOn) {
			direction = 0.0;
			speed = Speed.OFF;
		}
	}

	public Double getDirection() {
		return direction;
	}

	public Speed getSpeed() {
		return speed;
	}

	public void adjustSpeed(Speed speed) {
		this.speed = speed;
	}

	public void turn(Double adj) {
		direction = (direction + adj) % 360;
	}

	@Override
	public String toString() {
		String status = isOn ? "On" : "Off";
		return String.format("Fan: %s. Direction %.2f degrees. Speed %s",
				status, direction, speed);
	}
}
