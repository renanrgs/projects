package com.budgetplanner.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "BudgetDTO")
@Table(name = "budget")
public class BudgetDTO {

	@EmbeddedId
	private BudgetCompositePK id;

	@ManyToMany(mappedBy = "budgets")
	private Set<FinancialMovementDTO> subcategories = new HashSet<>();

	public BudgetDTO() {
		super();
		LocalDate period = LocalDate.now();
		this.id.setMonth(period.getMonthValue());
		this.id.setYear(period.getYear());
	}

	public BudgetCompositePK getId() {
		return id;
	}

	public void setId(BudgetCompositePK id) {
		this.id = id;
	}

	public Set<FinancialMovementDTO> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(Set<FinancialMovementDTO> subcategories) {
		this.subcategories = subcategories;
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
		BudgetDTO other = (BudgetDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
