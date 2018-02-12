package com.budgetplanner.balance.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.budgetplanner.domain.BalanceDTO;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.SubCategoryDTO;

@Service
public class BalanceServiceImpl implements BalanceService {

	@Override
	public BalanceDTO calculateTotal(BudgetDTO budget) {
		validate(budget);
		BalanceDTO balance = new BalanceDTO(budget);
		Double totalIncome = calculateTotal(budget.getIncome().getIncomeCategories());
		Double totalExpense = calculateTotal(budget.getExpense().getCategories());
		balance.setTotalIncome(totalIncome);
		balance.setTotalExpense(totalExpense);
		balance.setAmount(totalIncome - totalExpense);
		return balance;
	}

	private void validate(BudgetDTO budget) {
		if(budget == null) {
			throw new IllegalArgumentException();
		}
	}

	private Double calculateTotal(List<CategoryDTO> category) {
		Stream<SubCategoryDTO> subCategoryStream = category.stream().flatMap(cat -> cat.getSubCategories().stream());
		return subCategoryStream.reduce(0.0, (acc, subCategory) -> acc + subCategory.getAmount(),
				(amount1, amount2) -> amount1 + amount2);
	}
}
