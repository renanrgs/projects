package com.budgetplanner.commontests.budget;

import static com.budgetplanner.commontests.financialmovement.FinancialMovementForTests.netSalaryFromCompany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;

import com.budgetplanner.commontests.category.CategoryForTests;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.FinancialMovementDTO;

@Ignore
public class BudgetForTests {

	public static BudgetDTO validBudget() {
		BudgetDTO budgetDTO = new BudgetDTO(1, 2018);
		return budgetDTO;
	}

	private static BudgetDTO validBudget2() {
		List<CategoryDTO> incomeCategories = new ArrayList<>();
		List<CategoryDTO> expenseCategories = new ArrayList<>();

		CategoryDTO mainJob = CategoryForTests.mainJob();
		List<FinancialMovementDTO> subCategories = Arrays.asList(netSalaryFromCompany());
		incomeCategories.add(mainJob);
		return new BudgetDTO();
	}

	public static List<BudgetDTO> validBudgetList() {
		List<BudgetDTO> validBudgetList = new ArrayList<>();
		validBudgetList.add(validBudget());
		validBudgetList.add(validBudget2());
		return validBudgetList;
	}

	public static BudgetDTO budgetWithoutIncomeCategories() {
		List<CategoryDTO> expenseCategories = new ArrayList<>();
		CategoryDTO housingCategory = CategoryForTests.housing();

		return new BudgetDTO();
	}

	public static BudgetDTO nullBudget() {
		return null;
	}

	public static BudgetDTO budgetWithNullIncome() {
		List<CategoryDTO> expensesCaterogies = new ArrayList<>();
		return new BudgetDTO();

	}

	public static BudgetDTO budgetWithEmptyIncome() {
		List<CategoryDTO> incomeCategories = new ArrayList<>();

		return new BudgetDTO();
	}

	public static BudgetDTO budgetWithEmptyIncomeSubCategories() {
		List<CategoryDTO> incomeCategories = new ArrayList<>();
		List<CategoryDTO> expenseCategories = new ArrayList<>();

		CategoryDTO mainJob = CategoryForTests.mainJob();
		List<FinancialMovementDTO> IncomesubCategories = new ArrayList<>();
		incomeCategories.add(mainJob);

		CategoryDTO housingCategory = CategoryForTests.housing();
		expenseCategories.add(housingCategory);
		return new BudgetDTO();

	}
}
