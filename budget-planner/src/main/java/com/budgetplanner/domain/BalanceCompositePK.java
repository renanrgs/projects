package com.budgetplanner.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

//TODO Bidirectional relationship is required here.
@Embeddable
public class BalanceCompositePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private BudgetDTO budgetDTO;

	@ManyToOne
	private FinancialMovementDTO financialMovement;

	public BudgetDTO getBudgetDTO() {
		return budgetDTO;
	}

	public void setBudgetDTO(BudgetDTO budgetDTO) {
		this.budgetDTO = budgetDTO;
	}

	public FinancialMovementDTO getFinancialMovementDTO() {
		return financialMovement;
	}

	public void setFinancialMovementDTO(FinancialMovementDTO financialMovement) {
		this.financialMovement = financialMovement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((budgetDTO == null) ? 0 : budgetDTO.hashCode());
		result = prime * result + ((financialMovement == null) ? 0 : financialMovement.hashCode());
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
		if (financialMovement == null) {
			if (other.financialMovement != null)
				return false;
		} else if (!financialMovement.equals(other.financialMovement))
			return false;
		return true;
	}

}
