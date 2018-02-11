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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((incomeCategories == null) ? 0 : incomeCategories.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncomeDTO other = (IncomeDTO) obj;
		if (incomeCategories == null) {
			if (other.incomeCategories != null)
				return false;
		} else if (!incomeCategories.equals(other.incomeCategories))
			return false;
		return true;
	}

}
