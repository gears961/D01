package visitor;

public class PackagedItem extends Item{

    private double price;

    public PackagedItem(String name, double price) {
        super(name);
        this.price = price;
    }


    public double getPrice() {
        return price;
    }


    @Override
    public void accept(ItemVisitor v) {
        v.visitPackagedItem(this);
    }

    @Override
    public String toString() {
        return String.format("%-8s $%.2f", this.getName(), price);
    }
}