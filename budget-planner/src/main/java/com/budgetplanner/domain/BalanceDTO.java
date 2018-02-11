package com.budgetplanner.domain;

public class BalanceDTO {

	private BudgetDTO budgetDTO;

	public BalanceDTO(BudgetDTO budgetDTO) {
		this.budgetDTO = budgetDTO;
	}

	public BudgetDTO getBudgetDTO() {
		return budgetDTO;
	}

	public void setBudgetDTO(BudgetDTO budgetDTO) {
		this.budgetDTO = budgetDTO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((budgetDTO == null) ? 0 : budgetDTO.hashCode());
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
		BalanceDTO other = (BalanceDTO) obj;
		if (budgetDTO == null) {
			if (other.budgetDTO != null)
				return false;
		} else if (!budgetDTO.equals(other.budgetDTO))
			return false;
		return true;
	}

}
