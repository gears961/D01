package visitor;

import java.util.Calendar;

public class HappyDayDiscount extends CalendarDiscount{

    private int happyDay;

    public HappyDayDiscount(double discountRate, int happyDay) {
        super(discountRate);
        this.happyDay = happyDay;
    }

    @Override
    public boolean isApplicableToday() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return happyDay == day;
    }
}