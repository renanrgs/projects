package com.budgetplanner.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BudgetCompositePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "month")
	private Integer month;

	@Column(name = "year")
	private Integer year;

	public Integer getMonth() {
		return month;
	}

	public Integer getYear() {
		return year;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public void setYear(Integer year) {
		this.year = year;
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
		BudgetCompositePK other = (BudgetCompositePK) obj;
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
