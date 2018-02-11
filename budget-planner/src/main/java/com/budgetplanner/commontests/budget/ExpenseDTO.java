package com.budgetplanner.commontests.budget;

import java.util.List;

import com.budgetplanner.domain.CategoryDTO;

public class ExpenseDTO {

	private List<CategoryDTO> categories;

	public ExpenseDTO(List<CategoryDTO> categories) {
		this.categories = categories;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}

}
