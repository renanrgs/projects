package com.budgetplanner.commontests.budget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.budgetplanner.commontests.category.CategoryForTestsService;
import com.budgetplanner.commontests.subcategory.SubCategoryForTestsRepository;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.SubCategoryDTO;

public class BudgetForTestsService {

	public static BudgetDTO validBudget() {
		List<CategoryDTO> incomes = new ArrayList<>();
		List<CategoryDTO> expenses = new ArrayList<>();;
		
		CategoryDTO mainJob = CategoryForTestsService.mainJob();
		List<SubCategoryDTO> subCategories = Arrays.asList(SubCategoryForTestsRepository.netSalary());
		mainJob.setSubCategories(subCategories);
		incomes.add(mainJob);
		
		
		return new BudgetDTO(incomes, expenses);
	}

	public static BudgetDTO nullBudget() {
		return null;
	}

	public static BudgetDTO budgetWithNullIncome() {
		List<CategoryDTO> expenses= new ArrayList<>();
		
		return new BudgetDTO(null, expenses);

	}

	public static BudgetDTO budgetWithEmptyIncome() {
		List<CategoryDTO> incomes = new ArrayList<>();
		List<CategoryDTO> expenses = new ArrayList<>();
		
		return new BudgetDTO(incomes, expenses);
	}
}
