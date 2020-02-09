package visitor;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

  /**
   * Demonstrate the use of required classes.
   * @param args as usual
   */
  public static void main(String[] args) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(2019, 2, 20); // Mar 20 2019
    Date from = calendar.getTime();
    calendar.set(2019, 11, 15); // Apr 15 2019
    Date to = calendar.getTime();

    Item bulkItem = new BulkItem("sugar", 1.5, 0.9);
    Item packagedItem = new PackagedItem("milk", 6.99);
    List<Item> items = Arrays.asList(new Item[] {bulkItem, packagedItem});

    PriceCalculatorVisitor noDiscount = new PriceCalculatorVisitor(
        new NoDiscount(), new NoDiscount());
    Visitor.visitAll(items, noDiscount);

    PriceCalculatorVisitor pcConstDiscount = new PriceCalculatorVisitor(
        new NoDiscount(), new ConstantDiscount(5));
    Visitor.visitAll(items, pcConstDiscount);
    
    PriceCalculatorVisitor pcSeasonalDiscount = new PriceCalculatorVisitor(
        new SeasonalDiscount(0.1, from, to), new NoDiscount());
    Visitor.visitAll(items, pcSeasonalDiscount);

    PriceCalculatorVisitor pcSeasonalHappyDayDiscount = new PriceCalculatorVisitor(
        new SeasonalDiscount(0.1, from, to), 
        new HappyDayDiscount(0.5, Calendar.TUESDAY));
    Visitor.visitAll(items, pcSeasonalHappyDayDiscount);
    
    PrintVisitor pv = new PrintVisitor();
    Visitor.visitAll(items, pv);
    System.out.print(pv.getList());
    System.out.print(String.format("Total: %s\n\n", noDiscount.getTotal()));
    
    System.out.println(String.format("Today is %s.", new Date())); 
    System.out.println(String.format("Seasonal discount from %s to %s", from,  to));

    System.out.println(String.format(
        "With constant overall discount, total price is %.2f.", 
        pcConstDiscount.getTotal()));
    System.out.println(String.format(
        "With seasonal per item discount, total price is %.2f.", 
        pcSeasonalDiscount.getTotal()));
    System.out.println(String.format(
        "With seasonal per item discount and happy day overall discount, total price is %.2f.",
        pcSeasonalHappyDayDiscount.getTotal()));
  }

  /*
   * Expected output:

Item List:
sugar   0.90 lbs @ $1.50/lb
milk    $6.99
Total: 8.34

Today is Sun Mar 24 20:24:30 EDT 2019.
Seasonal discount from Wed Mar 20 20:24:30 EDT 2019 to Mon Apr 15 20:24:30 EDT 2019
With constant overall discount, total price is 3.34.
With seasonal per item discount, total price is 7.51.
With seasonal per item discount and happy day overall discount, total price is 3.75.

   */
}