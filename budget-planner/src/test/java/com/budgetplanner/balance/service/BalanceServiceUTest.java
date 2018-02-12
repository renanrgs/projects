package com.budgetplanner.balance.service;

import static com.budgetplanner.commontests.balance.BalanceForTestsService.budgetWithEmptyIncomeSubCategories;
import static com.budgetplanner.commontests.balance.BalanceForTestsService.budgetWithoutIncomeCategories;
import static com.budgetplanner.commontests.balance.BalanceForTestsService.nullBudget;
import static com.budgetplanner.commontests.balance.BalanceForTestsService.validBudget;
import static com.budgetplanner.commontests.balance.BalanceForTestsService.validBudgetList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
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

	@Test
	public void givenOneValidBudgetReturnBalanceAmount() {
		BalanceDTO balanceDTO = balanceService.calculateTotal(validBudget());
		assertThat(balanceDTO.getAmount(), equalTo(5400.0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void givenANullBudgetThrowAnException() {
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

	@Test
	public void givenValidBudgetListReturnBalanceList() {
		//TODO Need to complete this test immediately
		List<BalanceDTO> balances = balanceService.list(validBudgetList());
		assertThat(balances.size(), equalTo(2));
		balances.forEach(balance -> {
			assertThat(balance.getTotalExpense(), equalTo(2100.0));
			assertThat(balance.getTotalIncome(), equalTo(7500.0));
			assertThat(balance.getAmount(), equalTo(5400.0));
		});
	}
}
