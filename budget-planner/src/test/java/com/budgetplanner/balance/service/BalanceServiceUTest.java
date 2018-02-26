package com.budgetplanner.balance.service;

import static com.budgetplanner.commontests.budget.BudgetForTestsService.budgetWithoutExpense;
import static com.budgetplanner.commontests.budget.BudgetForTestsService.nullBudget;
import static com.budgetplanner.commontests.budget.BudgetForTestsService.validBudget;
import static com.budgetplanner.commontests.budget.BudgetForTestsService.validBudgetWithoutIncome;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.domain.BalanceDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BalanceServiceUTest {

	@Autowired
	private BalanceService balanceService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void givenValidBudgetThenReturnBalanceAmount() {
		BalanceDTO balanceDTO = balanceService.calculateTotal(validBudget());
		assertThat(balanceDTO.getAmount(), equalTo(1400.0));
	}

	@Test
	public void givenANullBudgetThrowAnException() {
		thrown.expect(IllegalArgumentException.class);
		balanceService.calculateTotal(nullBudget());
	}

	@Test
	public void givenBudgetWithoutIncomeReturnBalanceAmount() {
		BalanceDTO balanceDTO = balanceService.calculateTotal(validBudgetWithoutIncome());
		assertThat(balanceDTO.getAmount(), equalTo(-2100.0));
	}

	@Test
	public void givenBudgetWithoutExpenseReturnBalanceAmount() {
		BalanceDTO balanceDTO = balanceService.calculateTotal(budgetWithoutExpense());
		assertThat(balanceDTO.getAmount(), equalTo(3500.0));
	}
	
}
