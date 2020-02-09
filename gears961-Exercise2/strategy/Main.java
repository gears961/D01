package strategy;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Demo our Strategy implementation.
 * @author anya
 */
public class Main {

  /**
   * Makes some sample calls to our Strategy classes.
   * @param args as usual
   */
  public static void main(String[] args) {
    
    Calendar calendar = Calendar.getInstance();
    calendar.set(2019, 1, 20); // Feb 20 2019
    Date from = calendar.getTime();
    calendar.set(2019, 12, 15); // Mar 15 2019
    Date to = calendar.getTime();
    System.out.println(String.format("from %s to %s", from,  to));
    
    Discount cd = new ConstantDiscount(5);
    Discount sd = new SeasonalDiscount(0.2, from, to);
    Discount hdd = new HappyDayDiscount(0.5, Calendar.FRIDAY);
    
    PriceCalculator pc1 = new PriceCalculator(cd);
    PriceCalculator pc2 = new PriceCalculator(sd);
    PriceCalculator pc3 = new PriceCalculator(hdd);
    
    Priced usbStick = new Product("234523452345", 35);
    Priced headphones = new Product("345634563456", 120);
    Priced dress = new Product("123412341234", 80);

    List<Priced> stuff = Arrays.asList(new Priced [] {usbStick, headphones, dress});
    System.out.println("With no discount, total price is 235.");
    System.out.println(String.format("Today is %s.", new Date())); 
    System.out.println(String.format("With constant discount, total price is %.2f.", 
        pc1.getTotalPrice(stuff)));
    System.out.println(String.format("With seasonal discount, total price is %.2f.", 
        pc2.getTotalPrice(stuff)));
    System.out.println(String.format("With happy day discount, total price is %.2f.", 
        pc3.getTotalPrice(stuff)));
  }
/* OUTPUT
from Wed Feb 20 15:22:45 EST 2019 to Fri Mar 15 15:22:45 EDT 2019
With no discount, total price is 235.
Today is Fri Feb 22 15:22:45 EST 2019.
With constant discount, total price is 220.00.
With seasonal discount, total price is 188.00.
With happy day discount, total price is 117.50.
*/
}
