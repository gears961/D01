package turtlesolution;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * An Iterable collection of Turtles.
 * @author anya
 */
public class Turtles implements Iterable<Turtle> {

  public static final String TURTLE_NAME = "Turtle on ";

  @Override
  public Iterator<Turtle> iterator() {
    return new TurtleIterator();
  }

  private class TurtleIterator implements Iterator {

    @Override
    public boolean hasNext() {
      return true;
    }

    @Override
    public Object next() {
      return new Turtle(Turtles.TURTLE_NAME);
    }
  }

}
