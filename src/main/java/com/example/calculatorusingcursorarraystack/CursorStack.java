package com.example.calculatorusingcursorarraystack;

public class CursorStack<T extends Comparable<T>> implements StackInterface<T> {
	private CursorArray<T> cursor;
	private int list;
	private int size = 30;

	public CursorStack() {
		cursor = new CursorArray<>(size);
		list = cursor.createList();
	}

	public CursorStack(int size) {
		this.size = size;
		cursor = new CursorArray<>(size);
		list = cursor.createList();
	}

	@Override
	public void push(T data) throws IndexOutOfBoundsException {
		cursor.insertFirst(data, list);
	}

	@Override
	public T pop() {
		return cursor.deleteFirst(list);
	}

	@Override
	public T peek() {
		return cursor.returnFirst(list);
	}

	@Override
	public boolean isEmpty() {
		return cursor.isEmpty(list);
	}

	@Override
	public void clear() {
		cursor = new CursorArray<>(size);
		list = cursor.createList();

	}

	@Override
	public String toString() {
		return cursor.toString(list);
	}

}
