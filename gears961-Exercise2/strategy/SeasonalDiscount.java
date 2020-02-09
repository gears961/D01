package strategy;

import java.util.Date;

public class SeasonalDiscount extends CalendarDiscount {

    private java.util.Date from;
    private java.util.Date to;

    public SeasonalDiscount(double discountRate, Date from, Date to) {
        super(discountRate);
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean isApplicableToday() {
        Date today = new Date();
        return from.compareTo(today) * today.compareTo(to) >= 0;
    }
}
