package com.feiyangedu.sample;

import java.util.Iterator;

public class ReadOnlyList<E> implements Iterable<E> {

	E[] array;

	@SafeVarargs
	public ReadOnlyList(E... array) {
		this.array = array;
	}

	@Override
	public Iterator<E> iterator() {
		return new ReadOnlyIterator();
	}

	class ReadOnlyIterator implements Iterator<E> {
		int index = 0;

		@Override
		public boolean hasNext() {
			return index < ReadOnlyList.this.array.length;
		}

		@Override
		public E next() {
			E e = array[index];
			index++;
			return e;
		}
	}

}
