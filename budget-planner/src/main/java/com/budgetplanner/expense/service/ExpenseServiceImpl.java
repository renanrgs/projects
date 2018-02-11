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
		if (expenseDTO == null || expenseDTO.getCategories() == null) {
			throw new IllegalArgumentException();
		}
		if (expenseDTO.getCategories().stream()
				.anyMatch(category -> !TypeCategory.EXPENSE.equals(category.getTypeCategory()))) {
			throw new IllegalArgumentException();
		}
	}
}
