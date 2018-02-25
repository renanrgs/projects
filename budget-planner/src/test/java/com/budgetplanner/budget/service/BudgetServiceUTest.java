package com.budgetplanner.budget.service;

import static com.budgetplanner.commontests.budget.BudgetForTestsRepository.budgetWithNullIncome;
import static com.budgetplanner.commontests.budget.BudgetForTestsRepository.nullBudget;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.commontests.budget.BudgetForTestsRepository;
import com.budgetplanner.commontests.budget.BudgetForTestsService;
import com.budgetplanner.domain.BudgetDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BudgetServiceUTest {

	@Autowired
	private BudgetService budgetService;

	@Test
	public void givenValidBudgetThenSave() {
		budgetService.save(BudgetForTestsService.validBudget());
		List<BudgetDTO> budgets = budgetService.findAll();
		assertThat(budgets.size(), equalTo(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void insertThrowsExceptionWhenBudgetIsNull() {
		budgetService.save(nullBudget());
	}

	@Test(expected = IllegalArgumentException.class)
	public void insertThrowsExceptionWhenBudgetIncomeIsNull() {
		budgetService.save(budgetWithNullIncome());
	}

	@Test(expected = IllegalArgumentException.class)
	public void insertThrowsExceptionWhenBudgetIncomeIsEmpty() {
		budgetService.save(BudgetForTestsRepository.budgetWithEmptyIncome());
	}
}
