package com.budgetplanner.balance.service;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.budgetplanner.domain.BalanceDTO;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.SubCategoryDTO;

@Service
public class BalanceServiceImpl implements BalanceService {

	@Override
	public BalanceDTO calculate(BudgetDTO budget) {
		BalanceDTO balance = new BalanceDTO(budget);
		Double totalIncome = calculateTotalIncome(budget);
		Double totalExpense = calculateTotalExpense(budget);
		balance.setTotalIncome(totalIncome);
		balance.setTotalExpense(totalExpense);
		return balance;
	}

	private Double calculateTotalIncome(BudgetDTO budget) {
		Stream<CategoryDTO> categoryStream = budget.getIncome().getIncomeCategories().stream();
		Stream<SubCategoryDTO> subCategoryStream = categoryStream.flatMap(cat -> cat.getSubCategories().stream());
		return subCategoryStream.reduce(0.0, (acc, subCategory) -> acc + subCategory.getAmount(),
				(amount1, amount2) -> amount1 + amount2);
	}

	private Double calculateTotalExpense(BudgetDTO budget) {
		Stream<CategoryDTO> categoryStream = budget.getExpense().getCategories().stream();
		Stream<SubCategoryDTO> subCategoryStream = categoryStream.flatMap(cat -> cat.getSubCategories().stream());
		return subCategoryStream.reduce(0.0, (acc, subCategory) -> acc + subCategory.getAmount(),
				(amount1, amount2) -> amount1 + amount2);
	}
}
