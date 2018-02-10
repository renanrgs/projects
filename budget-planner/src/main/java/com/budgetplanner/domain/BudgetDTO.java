package com.budgetplanner.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class BudgetDTO {

	private Integer month;
	private Integer year;
	private LocalDate period;
	private Map<Integer, List<CategoryDTO>> incomes;
	private Map<Integer, List<CategoryDTO>> expenses;

	public BudgetDTO(Map<Integer, List<CategoryDTO>> incomes, Map<Integer, List<CategoryDTO>> expenses) {
		super();
		LocalDate period = LocalDate.now();
		this.month = period.getMonthValue();
		this.year = period.getYear();
		this.period = period;
		this.incomes = incomes;
		this.expenses = expenses;
	}

	public Integer getMonth() {
		return month;
	}

	public Integer getYear() {
		return year;
	}

	public LocalDate getPeriod() {
		return period;
	}

	public void setPeriod(LocalDate period) {
		this.period = period;
	}

	public Map<Integer, List<CategoryDTO>> getIncomes() {
		return incomes;
	}

	public void setIncomes(Map<Integer, List<CategoryDTO>> incomes) {
		this.incomes = incomes;
	}

	public Map<Integer, List<CategoryDTO>> getExpenses() {
		return expenses;
	}

	public void setExpenses(Map<Integer, List<CategoryDTO>> expenses) {
		this.expenses = expenses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		BudgetDTO other = (BudgetDTO) obj;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

}
