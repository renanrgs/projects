package com.budgetplanner.commontests.budget;

import static com.budgetplanner.commontests.subcategory.SubCategoryForTestsService.electricity;
import static com.budgetplanner.commontests.subcategory.SubCategoryForTestsService.netSalaryFromCompany;
import static com.budgetplanner.commontests.subcategory.SubCategoryForTestsService.rent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;

import com.budgetplanner.commontests.category.CategoryForTestsService;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.IncomeDTO;
import com.budgetplanner.domain.SubCategoryDTO;

@Ignore
public class BudgetForTestsService {

	public static BudgetDTO validBudget() {
		List<CategoryDTO> incomeCategories = new ArrayList<>();
		List<CategoryDTO> expenseCategories = new ArrayList<>();

		CategoryDTO mainJob = CategoryForTestsService.mainJob();
		List<SubCategoryDTO> categories = Arrays.asList(netSalaryFromCompany());
		mainJob.setSubCategories(categories);
		incomeCategories.add(mainJob);
		IncomeDTO income = new IncomeDTO(incomeCategories);

		CategoryDTO housingCategory = CategoryForTestsService.housing();
		housingCategory.setSubCategories(Arrays.asList(electricity(), rent()));
		expenseCategories.add(housingCategory);
		ExpenseDTO expense = new ExpenseDTO(expenseCategories);

		return new BudgetDTO(income, expense);
	}

	private static BudgetDTO validBudget2() {
		List<CategoryDTO> incomeCategories = new ArrayList<>();
		List<CategoryDTO> expenseCategories = new ArrayList<>();

		CategoryDTO mainJob = CategoryForTestsService.mainJob();
		List<SubCategoryDTO> subCategories = Arrays.asList(netSalaryFromCompany());
		mainJob.setSubCategories(subCategories);
		incomeCategories.add(mainJob);
		IncomeDTO income = new IncomeDTO(incomeCategories);

		CategoryDTO leisure = CategoryForTestsService.leisure();
		leisure.setSubCategories(Arrays.asList(electricity(), rent()));
		expenseCategories.add(leisure);
		ExpenseDTO expense = new ExpenseDTO(expenseCategories);

		return new BudgetDTO(income, expense);
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
		housingCategory.setSubCategories(Arrays.asList(electricity(), rent()));
		expenseCategories.add(housingCategory);
		ExpenseDTO expense = new ExpenseDTO(expenseCategories);

		List<CategoryDTO> incomeCategories = new ArrayList<>();
		IncomeDTO income = new IncomeDTO(incomeCategories);

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

	public static BudgetDTO budgetWithEmptyIncomeSubCategories() {
		List<CategoryDTO> incomeCategories = new ArrayList<>();
		List<CategoryDTO> expenseCategories = new ArrayList<>();

		CategoryDTO mainJob = CategoryForTestsService.mainJob();
		List<SubCategoryDTO> IncomesubCategories = new ArrayList<>();
		mainJob.setSubCategories(IncomesubCategories);
		incomeCategories.add(mainJob);
		IncomeDTO income = new IncomeDTO(incomeCategories);

		CategoryDTO housingCategory = CategoryForTestsService.housing();
		housingCategory.setSubCategories(Arrays.asList(electricity(), rent()));
		expenseCategories.add(housingCategory);
		ExpenseDTO expense = new ExpenseDTO(expenseCategories);

		return new BudgetDTO(income, expense);

	}
}
