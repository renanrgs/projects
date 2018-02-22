package com.budgetplanner.util.Validation;

@FunctionalInterface
public interface Validation<T> {

	void validate(T t);
}
