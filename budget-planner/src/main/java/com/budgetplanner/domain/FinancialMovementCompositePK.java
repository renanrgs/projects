package com.budgetplanner.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class FinancialMovementCompositePK implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryDTO categoryDTO;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryDTO == null) ? 0 : categoryDTO.hashCode());
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
		FinancialMovementCompositePK other = (FinancialMovementCompositePK) obj;
		if (categoryDTO == null) {
			if (other.categoryDTO != null)
				return false;
		} else if (!categoryDTO.equals(other.categoryDTO))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
