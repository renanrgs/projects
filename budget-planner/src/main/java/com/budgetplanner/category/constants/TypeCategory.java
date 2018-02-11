package com.budgetplanner.category.constants;

public enum TypeCategory {
	INCOME(1), EXPENSE(2);

	private Integer typeCategorie;

	private TypeCategory(Integer typeCategory) {
		this.typeCategorie = typeCategory;
	}

	public Integer getTypeCategory() {
		return this.typeCategorie;
	}
}
