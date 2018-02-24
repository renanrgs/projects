package com.budgetplanner.balance.service;

import static com.budgetplanner.commontests.balance.BalanceForTests.budgetWithEmptyIncomeSubCategories;
import static com.budgetplanner.commontests.balance.BalanceForTests.budgetWithoutIncomeCategories;
import static com.budgetplanner.commontests.balance.BalanceForTests.nullBudget;
import static com.budgetplanner.commontests.balance.BalanceForTests.validBudget;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.commontests.financialmovement.FinancialMovementForTests;
import com.budgetplanner.domain.BalanceDTO;
import com.budgetplanner.domain.FinancialMovementDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BalanceServiceUTest {

	@Autowired
	private BalanceService balanceService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void givenValidsFinancialMovementsThenReturnBalanceAmount() {
		BalanceDTO balanceDTO = balanceService.calculateTotal(FinancialMovementForTests.financialMovements());
		assertThat(balanceDTO.getAmount(), equalTo(5400.0));
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
