package com.budgetplanner.commontests.budget;

import static com.budgetplanner.commontests.financialmovement.FinancialMovementForTestsService.netSalaryFromCompany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;

import com.budgetplanner.commontests.category.CategoryForTestsService;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.FinancialMovementDTO;

@Ignore
public class BudgetForTestsService {

	public static BudgetDTO validBudget() {
		List<CategoryDTO> incomeCategories = new ArrayList<>();
		List<CategoryDTO> expenseCategories = new ArrayList<>();

		CategoryDTO mainJob = CategoryForTestsService.mainJob();
		List<FinancialMovementDTO> financialMovements = Arrays.asList(netSalaryFromCompany());
		
		BudgetDTO budgetDTO = new BudgetDTO();
		return budgetDTO;
	}

	private static BudgetDTO validBudget2() {
		List<CategoryDTO> incomeCategories = new ArrayList<>();
		List<CategoryDTO> expenseCategories = new ArrayList<>();

		CategoryDTO mainJob = CategoryForTestsService.mainJob();
		List<FinancialMovementDTO> subCategories = Arrays.asList(netSalaryFromCompany());
		incomeCategories.add(mainJob);
		return new BudgetDTO();
	}
	
	public static List<BudgetDTO> validBudgetList(){
		List<BudgetDTO> validBudgetList = new ArrayList<>();
		validBudgetList.add(validBudget());
		validBudgetList.add(validBudget2());
		return validBudgetList;
	}

	public static BudgetDTO budgetWithoutIncomeCategories() {
		List<CategoryDTO> expenseCategories = new ArrayList<>();
		CategoryDTO housingCategory = CategoryForTestsService.housing();


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

		CategoryDTO mainJob = CategoryForTestsService.mainJob();
		List<FinancialMovementDTO> IncomesubCategories = new ArrayList<>();
		incomeCategories.add(mainJob);

		CategoryDTO housingCategory = CategoryForTestsService.housing();
		expenseCategories.add(housingCategory);
		return new BudgetDTO();

	}
}
