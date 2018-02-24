package com.budgetplanner.balance.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.budget.repository.BudgetRepository;
import com.budgetplanner.category.repository.CategoryRepository;
import com.budgetplanner.commontests.balance.BalanceForTests;
import com.budgetplanner.commontests.financialmovement.FinancialMovementForTests;
import com.budgetplanner.domain.BalanceDTO;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.FinancialMovementDTO;
import com.budgetplanner.flow.repository.FlowRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BalanceRepositoryUTest {

	@Autowired
	private BalanceRepository balanceRepository;

	private BudgetDTO budget;

	private FinancialMovementDTO financialMovement;

	@Autowired
	private BudgetRepository budgetRepository;

	@Autowired
	private FlowRepository flowRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Before
	public void setUp() {
		BalanceForTests.setDependecies(FinancialMovementForTests.validFinancialMovement(), flowRepository,
				categoryRepository, budgetRepository);
	}

	@Test
	public void givenValidBalanceThenSave() {
		BalanceDTO balance = BalanceForTests.validBalance();
		balance.setBudget(budget);
		balance.setFinancialMovement(financialMovement);
		balanceRepository.save(balance);
	}
}
