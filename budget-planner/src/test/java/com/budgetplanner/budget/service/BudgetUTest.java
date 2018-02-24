package com.budgetplanner.budget.service;

import static com.budgetplanner.commontests.budget.BudgetForTests.budgetWithNullIncome;
import static com.budgetplanner.commontests.budget.BudgetForTests.nullBudget;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.budget.repository.BudgetRepository;
import com.budgetplanner.commontests.budget.BudgetForTests;
import com.budgetplanner.domain.BudgetDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BudgetUTest {

	@Autowired
	private BudgetRepository budgetRepository;

	@Autowired
	private BudgetService budgetService;

	private List<BudgetDTO> budgets;

	@Before
	public void setUp() {
		budgets = new ArrayList<>();
	}

	@Test
	public void insertValidBudget() {
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void insertThrowsExceptionWhenBudgetIsNull() {
		budgetService.insert(nullBudget());
	}

	@Test(expected = IllegalArgumentException.class)
	public void insertThrowsExceptionWhenBudgetIncomeIsNull() {
		budgetService.insert(budgetWithNullIncome());
	}

	@Test(expected = IllegalArgumentException.class)
	public void insertThrowsExceptionWhenBudgetIncomeIsEmpty() {
		budgetService.insert(BudgetForTests.budgetWithEmptyIncome());
	}
}
