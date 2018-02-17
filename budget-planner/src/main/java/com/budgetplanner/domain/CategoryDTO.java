package com.budgetplanner.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.budgetplanner.category.constants.TypeFlow;

@Entity(name = "CategoryDTO")
@Table(name = "category")
public class CategoryDTO {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(columnDefinition = "CHAR (30)", nullable = false)
	private String name;

	@OneToMany(mappedBy = "categoryDTO", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SubCategoryDTO> subCategories;

	@ManyToOne
	private FlowDTO flowDTO;

	public CategoryDTO(Integer id, String name, List<SubCategoryDTO> subCategories, TypeFlow typeCategory) {
		super();
		this.id = id;
		this.name = name;
		this.subCategories = subCategories;
		this.setFlowDTO(typeCategory.getFlowDTO());
	}

	public void addSubCategoryDTO(SubCategoryDTO subCategoryDTO) {
		this.subCategories.add(subCategoryDTO);
		subCategoryDTO.setCategoryDTO(this);
	}

	public void removeSubCategoryDTO(SubCategoryDTO subCategoryDTO) {
		this.subCategories.remove(subCategoryDTO);
		subCategoryDTO.setCategoryDTO(null);
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

	public List<SubCategoryDTO> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategoryDTO> subCategories) {
		this.subCategories = subCategories;
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
		CategoryDTO other = (CategoryDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public FlowDTO getFlowDTO() {
		return flowDTO;
	}

	public void setFlowDTO(FlowDTO flowDTO) {
		this.flowDTO = flowDTO;
	}

}
