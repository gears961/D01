package strategy;

import java.util.Calendar;

public class HappyDayDiscount extends CalendarDiscount {

    private int happyDay;

    public HappyDayDiscount(double discountRate, int happyDay) {
        super(discountRate);
        this.happyDay = happyDay;
    }

    @Override
    public boolean isApplicableToday() {
        Calendar myDate = Calendar.getInstance();
        int dow = myDate.get(Calendar.DAY_OF_WEEK);
        return dow == happyDay;
    }
}
