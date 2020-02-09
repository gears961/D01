package switchboardstarter;

public class Temperature implements Comparable<Temperature>{
	public static final double epsilon = 0.1;
	
	private Double degrees;
	
	public Temperature(Double degrees) {
		this.degrees = degrees;
	}
	
	public Double getValue() {
		return degrees;
	}
	
	public void adjust(Double diff) {
		degrees += diff;
	}

	@Override
	public int compareTo(Temperature other) {
		if (this.equals(other))
			return 0;
		return  (int) Math.signum(degrees - other.getValue());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass())
			return false;
		Temperature other = (Temperature) obj;
		return Math.abs(degrees - other.getValue()) < epsilon;
	}

	@Override
	public String toString() {
		return String.format("%.2f degrees", degrees);
	}
}
