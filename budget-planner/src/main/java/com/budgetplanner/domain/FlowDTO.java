package com.budgetplanner.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "FlowDTO")
@Table(name = "flow")
public class FlowDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5282536212966577606L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(columnDefinition = "CHAR(30)")
	private String name;

	@OneToMany(mappedBy = "flowDTO", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CategoryDTO> categories;

	public FlowDTO() {
	}

	public FlowDTO(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public void addCategoryDTO(CategoryDTO categoryDTO) {
		categories.add(categoryDTO);
		categoryDTO.setFlowDTO(this);
	}

	public void removeCategoryDTO(CategoryDTO categoryDTO) {
		categories.remove(categoryDTO);
		categoryDTO.setFlowDTO(null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		FlowDTO other = (FlowDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}

}
