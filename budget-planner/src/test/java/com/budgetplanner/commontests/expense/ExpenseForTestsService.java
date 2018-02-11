package com.budgetplanner.commontests.expense;

import java.util.Arrays;

import com.budgetplanner.commontests.budget.ExpenseDTO;
import com.budgetplanner.commontests.category.CategoryForTestsService;

public class ExpenseForTestsService {

	public static ExpenseDTO oneValidExpense() {
		return new ExpenseDTO(Arrays.asList(CategoryForTestsService.housing()));
	}

}
