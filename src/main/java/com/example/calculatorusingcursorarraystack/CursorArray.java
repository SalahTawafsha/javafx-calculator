package com.example.calculatorusingcursorarraystack;

public class CursorArray<T extends Comparable<T>> {
	private int size = 10;

	Node<T>[] arr;

	@SuppressWarnings("unchecked")
	public CursorArray(int size) {
		super();
		this.size = size;
		arr = new Node[size];
		initialization();
	}

	@SuppressWarnings("unchecked")
	public CursorArray() {
		arr = new Node[size];
		initialization();
	}

	private void initialization() {
		for (int i = 0; i < arr.length - 1; i++)
			arr[i] = new Node<T>(null, i + 1);

		arr[arr.length - 1] = new Node<>(null, 0);
	}

	public int malloc() {
		int i = arr[0].getNext();
		arr[0].setNext(arr[i].getNext());
		return i;
	}

	public void free(int p) {
		arr[p] = new Node<T>(null, arr[0].getNext());
		arr[0].setNext(p);
	}

	public boolean isNull(int i) {
		return arr[i] == null;
	}

	public boolean isEmpty(int l) {
		return arr[l].getNext() == 0;
	}

	public boolean isLast(int p) {
		return arr[p].getNext() == 0;
	}

	public int createList() {
		int p = malloc();
		if (p != 0)
			arr[p].setNext(0);
		else
			p = -1;
		return p;
	}

	public void insert(T data, int l) {
		int i, j;
		for (j = l, i = arr[l].getNext(); i != 0 && !isNull(i) && !isLast(i)
				&& arr[i].getData().compareTo(data) < 0; j = i, i = arr[i].getNext())
			;

		int p = malloc();
		if (p != 0) {
			if (i == l) {
				arr[p] = new Node<>(data, 0);
				arr[l].setNext(p);
			} else if (i == 0) {
				arr[j].setNext(p);
				arr[p] = new Node<T>(data, 0);
			} else {
				arr[j].setNext(p);
				arr[p] = new Node<T>(data, i);
			}
		}

	}

	public void insertFirst(T data, int l) throws IndexOutOfBoundsException {
		if (isNull(l))
			return;
		int p = malloc();
		if (p != 0) {
			arr[p] = new Node<>(data, arr[l].getNext());
			arr[l].setNext(p);
		} else
			throw new IndexOutOfBoundsException("cursor array is Full");
	}

	public int find(T data, int l) {
		while (!isNull(l) && !isEmpty(l)) {
			l = arr[l].getNext();
			if (arr[l].getData().equals(data))
				return l;
		}
		return -1; // not found
	}

	public int findPrevious(T data, int l) {
		while (!isNull(l) && !isEmpty(l)) {
			if (arr[arr[l].getNext()].getData().equals(data))
				return l;
			l = arr[l].getNext();
		}
		return -1; // not found
	}

	public Node<T> delete(T data, int l) {
		int p = findPrevious(data, l);
		if (p != -1) {
			int c = arr[p].getNext();
			Node<T> temp = arr[c];
			arr[p].setNext(temp.getNext());
			free(c);
		}
		return null;
	}

	public T deleteFirst(int l) {
		if (!isNull(l) && !isEmpty(l)) {
			int c = arr[l].getNext();
			Node<T> temp = arr[c];
			arr[l].setNext(temp.getNext());
			free(c);
			return temp.getData();
		}
		return null;

	}

	public T returnFirst(int l) {

		int c = arr[l].getNext();
		Node<T> temp = arr[c];

		return temp.getData();
	}

	public String toString(int l) {
		String s = "head -> ";
		while (!isLast(l) && !isNull(l)) {
			l = arr[l].getNext();
			s += arr[l].toString() + " -> ";
		}

		s += "NULL";
		return s;
	}

	public int getSize() {
		return size;
	}

}
