package com.budgetplanner.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "BalanceDTO")
@Table(name = "balance")
public class BalanceDTO {

	@EmbeddedId
	private BalanceCompositePK id;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "total_income")
	private Double totalIncome;

	@Column(name = "total_expense")
	private Double totalExpense;

	public BalanceDTO(BudgetDTO budgetDTO) {
		this.id = new BalanceCompositePK();
		this.id.setBudgetDTO(budgetDTO);
	}

	public BalanceDTO(BudgetDTO budget, FinancialMovementDTO financialMovement) {
		this.id = new BalanceCompositePK();
		this.getId().setBudgetDTO(budget);
		this.getId().setFinancialMovementDTO(financialMovement);
	}
	
	public BalanceDTO() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Double getAmount() {
		return this.amount;
	}

	public BalanceCompositePK getId() {
		return id;
	}

	public void setId(BalanceCompositePK id) {
		this.id = id;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(Double totalExpense) {
		this.totalExpense = totalExpense;
	}

	public Double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(Double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public void setBudget(BudgetDTO budget) {
		this.getId().setBudgetDTO(budget);
	}

	public void setFinancialMovement(FinancialMovementDTO financialMovement) {
		this.id.setFinancialMovementDTO(financialMovement);
	}

}
