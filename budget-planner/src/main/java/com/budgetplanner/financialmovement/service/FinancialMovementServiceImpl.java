package com.budgetplanner.financialmovement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.budgetplanner.domain.FinancialMovementDTO;
import com.budgetplanner.financialmovement.repository.FinancialMovementRepository;

@Service
public class FinancialMovementServiceImpl implements FinancialMovementService {

	@Autowired
	private FinancialMovementRepository subCategoryRepository;

	@Value("${erro.subcategory.null}")
	private String erro;

	
	
	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public void add(FinancialMovementDTO subCategoryDTO) {
		validate(subCategoryDTO);
		subCategoryRepository.add(subCategoryDTO);
	}

	private void validate(FinancialMovementDTO subCategoryDTO) {
		if (subCategoryDTO == null || subCategoryDTO.getId() == null || subCategoryDTO.getName() == null) {
			throw new IllegalArgumentException(erro);
		}
		if (subCategoryDTO.getId().getId() < 0 || subCategoryDTO.getId().getId() > 200) {
			throw new IllegalArgumentException(erro);
		}
	}

	public List<FinancialMovementDTO> list() {
		return null;
	}
}
