package controllersstarter;

public class RefrigeratorController extends TempController {

    private Refrigerator refrigerator;

    public RefrigeratorController(Refrigerator refrigerator) {
        super(refrigerator);
        this.refrigerator = refrigerator;
        this.setTargetTemp(null);
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

    @Override
    public void control() {
        if (refrigerator != null && refrigerator.isOn()) {
            if (refrigerator.isDoorOpen()) {
                refrigerator.setLightOn(true);
            } else {
                refrigerator.setLightOn(false);
            }
            if (refrigerator.getCurrentTemp().compareTo(this.getTargetTemp()) > 0) {
                while (!refrigerator.getCurrentTemp().equals(this.getTargetTemp()))
                    refrigerator.timeTick(); // cheating to simplify
            }

        }
    }
}
