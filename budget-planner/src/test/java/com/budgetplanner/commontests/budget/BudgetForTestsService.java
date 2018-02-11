package com.budgetplanner.commontests.budget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.budgetplanner.commontests.category.CategoryForTestsService;
import com.budgetplanner.commontests.subcategory.SubCategoryForTestsRepository;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.IncomeDTO;
import com.budgetplanner.domain.SubCategoryDTO;

public class BudgetForTestsService {

	public static BudgetDTO validBudget() {
		List<CategoryDTO> incomeCategories = new ArrayList<>();
		List<CategoryDTO> expenseCategories = new ArrayList<>();

		CategoryDTO mainJob = CategoryForTestsService.mainJob();
		List<SubCategoryDTO> subCategories = Arrays.asList(SubCategoryForTestsRepository.netSalary());
		mainJob.setSubCategories(subCategories);
		incomeCategories.add(mainJob);
		IncomeDTO income = new IncomeDTO(incomeCategories);

		ExpenseDTO expense = new ExpenseDTO(expenseCategories);

		return new BudgetDTO(income, expense);
	}

	public static BudgetDTO nullBudget() {
		return null;
	}

	public static BudgetDTO budgetWithNullIncome() {
		List<CategoryDTO> expensesCaterogies = new ArrayList<>();

		return new BudgetDTO(null, new ExpenseDTO(expensesCaterogies));

	}

	public static BudgetDTO budgetWithEmptyIncome() {
		List<CategoryDTO> incomeCategories = new ArrayList<>();
		IncomeDTO income = new IncomeDTO(incomeCategories);
		ExpenseDTO expense = new ExpenseDTO(new ArrayList<CategoryDTO>());

		return new BudgetDTO(income, expense);
	}
}
