package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class LogicsImpl implements Logics {

	private List<Integer> values;
	
	public LogicsImpl(final int size) {
		this.values = new ArrayList<>(Collections.nCopies(size, 0));
	}

	@Override
	public int size() {
		return this.values.size();
	}

	@Override
	public List<Integer> values() {
		return this.values;
	}

	@Override
	public List<Boolean> enablings() {
		return values.stream()
			.map(d -> d != values.size())
			.toList();
	}

	@Override
	public int hit(int elem) {
		if (this.enablings().get(elem)) {
			int value = values.get(elem);
			values.set(elem, ++value);
		}
		return this.values.get(elem);
	}

	@Override
	public String result() {
		return this.values.stream()
			.map(d -> d.toString())
			.collect(Collectors.joining("|", "<<", ">>"));
	}
	
	@Override
	public boolean toQuit() {
		return values.stream()
			.allMatch(i -> i == this.values.get(0));
	}
}
