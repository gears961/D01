package controllersstarter;

public class HeaterController extends TempController {

    private Heater heater;

    public HeaterController(Heater heater) {
        super(heater);
        this.heater = heater;
    }

    @Override
    public void control() {
        if (heater.isOn()) {
            if (heater.getCurrentTemp().compareTo(this.getTargetTemp()) < 0) {
                while (!heater.getCurrentTemp().equals(this.getTargetTemp()))
                    heater.timeTick(); // cheating to simplify
            }
        }
    }
}
