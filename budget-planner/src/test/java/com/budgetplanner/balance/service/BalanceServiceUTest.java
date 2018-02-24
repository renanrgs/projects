package com.budgetplanner.balance.service;

import static com.budgetplanner.commontests.balance.BalanceForTests.budgetWithEmptyIncomeSubCategories;
import static com.budgetplanner.commontests.balance.BalanceForTests.budgetWithoutIncomeCategories;
import static com.budgetplanner.commontests.balance.BalanceForTests.nullBudget;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.commontests.budget.BudgetForTestsService;
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
		BalanceDTO balanceDTO = balanceService.calculateTotal(BudgetForTestsService.validBudget());
		assertThat(balanceDTO.getAmount(), equalTo(1400.0));
	}

	@Test
	public void givenANullBudgetThrowAnException() {
		thrown.expect(IllegalArgumentException.class);
		balanceService.calculateTotal(nullBudget());
	}

	@Test
	public void givenBudgetWithoutIncomeCategoriesReturnBalanceAmount() {
		BalanceDTO balanceDTO = balanceService.calculateTotal(budgetWithoutIncomeCategories());
		assertThat(balanceDTO.getAmount(), equalTo(-2100.0));
	}

	@Test
	public void givenBudgetWithoutIncomeSubCategoriesReturnBalanceAmount() {
		BalanceDTO balanceDTO = balanceService.calculateTotal(budgetWithEmptyIncomeSubCategories());
		assertThat(balanceDTO.getAmount(), equalTo(-2100.0));
	}

}
