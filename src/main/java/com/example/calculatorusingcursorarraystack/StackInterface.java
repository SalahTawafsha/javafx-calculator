package com.example.calculatorusingcursorarraystack;

public interface StackInterface<T> {
	void push(T data);

	T pop();

	T peek();

	boolean isEmpty();

	void clear();
}
