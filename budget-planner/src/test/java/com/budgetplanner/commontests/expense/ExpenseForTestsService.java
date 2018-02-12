package com.budgetplanner.commontests.expense;

import java.util.Arrays;

import com.budgetplanner.commontests.budget.ExpenseDTO;
import com.budgetplanner.commontests.category.CategoryForTestsService;

public class ExpenseForTestsService {

	public static ExpenseDTO oneValidExpense() {
		return new ExpenseDTO(Arrays.asList(CategoryForTestsService.housing()));
	}

	public static ExpenseDTO expenseWithOneInvalidCategoryType() {

		return new ExpenseDTO(Arrays.asList(CategoryForTestsService.housing(), CategoryForTestsService.mainJob()));
	}

	public static ExpenseDTO expenseWithNullCategories() {
		return new ExpenseDTO(null);
	}

	public static ExpenseDTO expenseLowerThanZero() {
		return new ExpenseDTO(Arrays.asList(CategoryForTestsService.expenseCategoryWithSubCategoryLowerThanZero()));
	}

	public static ExpenseDTO nullExpense() {
		return null;
	}

}
