package com.budgetplanner.income.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetplanner.category.constants.TypeCategory;
import com.budgetplanner.domain.IncomeDTO;
import com.budgetplanner.income.repository.IncomeRepository;

@Service
public class IncomeServiceImpl implements IncomeService {

	@Autowired
	private IncomeRepository incomeRepository;

	@Override
	public void insert(IncomeDTO incomeDTO) {
		validate(incomeDTO);
		incomeRepository.insert(incomeDTO);
	}

	private void validate(IncomeDTO incomeDTO) {
		if (incomeDTO.getIncomeCategories().stream()
				.anyMatch(category -> !TypeCategory.INCOME.equals(category.getTypeCategory())))
			throw new IllegalArgumentException();
	}

}
