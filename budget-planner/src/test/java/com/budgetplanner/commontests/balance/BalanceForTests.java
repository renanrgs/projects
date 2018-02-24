package com.budgetplanner.commontests.balance;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.budgetplanner.budget.repository.BudgetRepository;
import com.budgetplanner.category.repository.CategoryRepository;
import com.budgetplanner.commontests.budget.BudgetForTests;
import com.budgetplanner.commontests.category.CategoryForTests;
import com.budgetplanner.commontests.financialmovement.FinancialMovementForTests;
import com.budgetplanner.commontests.flow.FlowForTests;
import com.budgetplanner.domain.BalanceDTO;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.FinancialMovementDTO;
import com.budgetplanner.domain.FlowDTO;
import com.budgetplanner.flow.repository.FlowRepository;

public class BalanceForTests {

	public static BudgetDTO validBudget() {
		return BudgetForTests.validBudget();
	}

	public static List<BudgetDTO> validBudgetList(){
		return BudgetForTests.validBudgetList();
	}
	
	public static BudgetDTO nullBudget() {
		return BudgetForTests.nullBudget();
	}
	
	public static BudgetDTO budgetWithoutIncomeCategories() {
		return BudgetForTests.budgetWithoutIncomeCategories();
	}
	
	public static BudgetDTO budgetWithEmptyIncomeSubCategories() {
		return BudgetForTests.budgetWithEmptyIncomeSubCategories();
	}

	public static BalanceDTO validBalance() {
		BudgetDTO budget = BudgetForTests.validBudget();
		FinancialMovementDTO financialMovement = FinancialMovementForTests.validFinancialMovement();
		BalanceDTO balance = new BalanceDTO(budget , financialMovement);
		return balance;
	}
	
	public static void setDependecies(FinancialMovementDTO financialMovement,
			FlowRepository flowRepository, CategoryRepository categoryRepository, BudgetRepository budgetRepository) {
			FlowDTO incomeFlow = flowRepository.save(FlowForTests.incomeFlow());
			CategoryDTO mainJob = CategoryForTests.mainJob();
			mainJob.setFlowDTO(incomeFlow);
			categoryRepository.save(mainJob);
			budgetRepository.save(BudgetForTests.validBudget());
			Set<BudgetDTO> budgets = new HashSet<>();
			budgetRepository.findAll().forEach(budget -> budgets.add(budget));
			financialMovement.setBudgets(budgets);
			financialMovement.setCategoryDTO(mainJob);
		}
}
