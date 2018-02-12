package com.budgetplanner.expense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetplanner.category.constants.TypeCategory;
import com.budgetplanner.commontests.budget.ExpenseDTO;
import com.budgetplanner.expense.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public void insert(ExpenseDTO expenseDTO) {
		validate(expenseDTO);
		expenseRepository.insert(expenseDTO);
	}

	private void validate(ExpenseDTO expenseDTO) {
		validateNull(expenseDTO);
		validateTypeCategory(expenseDTO);
		validateLowerThanZero(expenseDTO);
	}

	private void validateNull(ExpenseDTO expenseDTO) {
		if (expenseDTO == null || expenseDTO.getCategories() == null) {
			throw new IllegalArgumentException();
		}
	}

	private void validateLowerThanZero(ExpenseDTO expenseDTO) {
		boolean subCategoryAmountLowerThanZero = expenseDTO.getCategories().stream()
				.flatMap((cat) -> cat.getSubCategories().stream().filter(subCategory -> subCategory.getAmount() < 0))
				.count() > 0;
		if (subCategoryAmountLowerThanZero)
			throw new IllegalArgumentException();
	}

	private void validateTypeCategory(ExpenseDTO expenseDTO) {
		if (expenseDTO.getCategories().stream()
				.anyMatch(category -> !TypeCategory.EXPENSE.equals(category.getTypeCategory()))) {
			throw new IllegalArgumentException();
		}
	}
}
