package com.budgetplanner.commontests.balance;

import java.util.HashSet;
import java.util.Set;

import com.budgetplanner.budget.repository.BudgetRepository;
import com.budgetplanner.category.repository.CategoryRepository;
import com.budgetplanner.commontests.budget.BudgetForTestsRepository;
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

	public static BalanceDTO validBalance() {
		BudgetDTO budget = BudgetForTestsRepository.validBudget();
		FinancialMovementDTO financialMovement = FinancialMovementForTests.validFinancialMovement();
		BalanceDTO balance = new BalanceDTO(budget, financialMovement);
		return balance;
	}

	public static void setDependecies(FinancialMovementDTO financialMovement, FlowRepository flowRepository,
			CategoryRepository categoryRepository, BudgetRepository budgetRepository) {
		FlowDTO incomeFlow = flowRepository.save(FlowForTests.incomeFlow());
		CategoryDTO mainJob = CategoryForTests.mainJob();
		mainJob.setFlowDTO(incomeFlow);
		categoryRepository.save(mainJob);
		budgetRepository.save(BudgetForTestsRepository.validBudget());
		Set<BudgetDTO> budgets = new HashSet<>();
		budgetRepository.findAll().forEach(budget -> budgets.add(budget));
		financialMovement.setBudgets(budgets);
		financialMovement.setCategoryDTO(mainJob);
	}
}
