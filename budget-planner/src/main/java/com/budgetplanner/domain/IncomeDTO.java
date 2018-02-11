package com.budgetplanner.domain;

import java.util.List;

public class IncomeDTO {

	private List<CategoryDTO> incomeCategories;

	public IncomeDTO(List<CategoryDTO> incomeCategories) {
		this.incomeCategories = incomeCategories;
	}

	public List<CategoryDTO> getIncomeCategories() {
		return incomeCategories;
	}

	public void setIncomeCategories(List<CategoryDTO> incomeCategories) {
		this.incomeCategories = incomeCategories;
	}

}
