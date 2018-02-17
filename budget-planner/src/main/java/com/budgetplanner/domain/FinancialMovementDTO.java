package com.budgetplanner.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "FinalcialMovementDTO")
@Table(name = "financial_movement")
public class FinancialMovementDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7432342599784011594L;

	@EmbeddedId
	private FinancialMovementCompositePK id;

	@Column(nullable = false, columnDefinition = "CHAR(30)")
	private String name;

	@Column(nullable = false)
	private Double amount;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "budget_subcategory", joinColumns = { @JoinColumn(name = "budget_month"),
			@JoinColumn(name = "budget_year") }, inverseJoinColumns = { @JoinColumn(name = "subcategory_id"),
					@JoinColumn(name = "subcategory_category_id") })
	private Set<BudgetDTO> budgets = new HashSet<>();

	public FinancialMovementDTO(Integer id, String name, Double amount, CategoryDTO categoryDTO) {
		super();
		this.id = new FinancialMovementCompositePK();
		this.id.setId(id);
		this.name = name;
		this.amount = amount;
		this.id.setCategoryDTO(categoryDTO);
	}

	public FinancialMovementCompositePK getId() {
		return id;
	}

	public void setId(FinancialMovementCompositePK id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		FinancialMovementDTO other = (FinancialMovementDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Set<BudgetDTO> getBudgets() {
		return budgets;
	}

	public void setBudgets(Set<BudgetDTO> budgets) {
		this.budgets = budgets;
	}

}
