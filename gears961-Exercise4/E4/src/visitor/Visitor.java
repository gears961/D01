package visitor;

import java.util.Collection;

/**
 * A class to represent the Client or a Visitor.
 */
public class Visitor {

    /**
     * Visit a collection of items using a given visitor.
     *
     * @param items the collection of items
     * @param visitor the visitor
     */
    public static void visitAll(Collection<Item> items, ItemVisitor visitor) {
        for (Item i: items) {
            i.accept(visitor);
        }
    }
}