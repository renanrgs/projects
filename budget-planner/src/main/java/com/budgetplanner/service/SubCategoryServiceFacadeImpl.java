package com.budgetplanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

import com.budgetplanner.domain.SubCategoryDTO;
import com.budgetplanner.subcategory.repository.SubCategoryRepository;

@Service
public class SubCategoryServiceFacadeImpl implements SubCategoryService {

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Value("${erro.subcategory.null}")
	private String erro;

	
	
	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public Boolean add(SubCategoryDTO subCategoryDTO) {
		validate(subCategoryDTO);
		return subCategoryRepository.add(subCategoryDTO);
	}

	private void validate(SubCategoryDTO subCategoryDTO) {
		if (subCategoryDTO == null || subCategoryDTO.getId() == null || subCategoryDTO.getName() == null) {
			System.out.println(erro);
			throw new IllegalArgumentException(erro);
		}
		if (subCategoryDTO.getId() < 0 || subCategoryDTO.getId() > 200) {
			throw new IllegalArgumentException(erro);
		}
	}

	public List<SubCategoryDTO> list() {
		return null;
	}
}
