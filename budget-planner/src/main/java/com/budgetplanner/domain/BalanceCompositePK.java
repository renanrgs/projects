package com.budgetplanner.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

//TODO Bidirectional relationship need to be coded.
@Embeddable
public class BalanceCompositePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private BudgetDTO budgetDTO;

	@ManyToOne
	private FinancialMovementDTO subCategoryDTO;

	public BudgetDTO getBudgetDTO() {
		return budgetDTO;
	}

	public void setBudgetDTO(BudgetDTO budgetDTO) {
		this.budgetDTO = budgetDTO;
	}

	public FinancialMovementDTO getSubCategoryDTO() {
		return subCategoryDTO;
	}

	public void setSubCategoryDTO(FinancialMovementDTO subCategoryDTO) {
		this.subCategoryDTO = subCategoryDTO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((budgetDTO == null) ? 0 : budgetDTO.hashCode());
		result = prime * result + ((subCategoryDTO == null) ? 0 : subCategoryDTO.hashCode());
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
		BalanceCompositePK other = (BalanceCompositePK) obj;
		if (budgetDTO == null) {
			if (other.budgetDTO != null)
				return false;
		} else if (!budgetDTO.equals(other.budgetDTO))
			return false;
		if (subCategoryDTO == null) {
			if (other.subCategoryDTO != null)
				return false;
		} else if (!subCategoryDTO.equals(other.subCategoryDTO))
			return false;
		return true;
	}

}
