package controllersstarter;

public class Fan extends Device {

	public enum Speed {
		OFF, LOW, MEDIUM, HIGH; 
	}
	private Double direction;
	private Speed speed;

	public Fan() {
		this.setIsOn(false);
		direction = 0.0;
		speed = Speed.OFF;
	}

	public Double getDirection() {
		return direction;
	}

	public void turn(Double direction) {
		this.direction = direction;
	}

	public Speed getSpeed() {
		return speed;
	}

	public void adjustSpeed(Speed speed) {
		this.speed = speed;
	}


	@Override
	public String toString() {
		String status = this.isOn() ? "On" : "Off";
		return String.format("Fan: %s. Direction %.2f degrees. Speed %s",
				status, direction, speed);
	}
}
