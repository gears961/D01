package switchboardstarter;

import java.util.Collection;
import java.util.Iterator;

public class SwitchBoard implements Iterator<Controller>, Iterable<Controller>{

	private Collection<Controller> c;
	private int i = 0;

	public SwitchBoard(Collection<Controller> controllers) {
		this.c = controllers;
	}

	@Override
	public String toString() {
		return String.format("SwitchBoard: ???.");
	}

	public boolean hasNext() {
		return true;
	}

	public Controller next() {
		Controller newC = c.toArray(new Controller[0])[i];
		if(i >= c.size() - 1) {
			i = 0;
		} else {
			i++;
		}
		return newC;
	}

	public final Iterator<Controller> iterator() {
		return this;
	}
}
