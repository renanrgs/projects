package com.budgetplanner.budget.service;

import static com.budgetplanner.commontests.budget.BudgetForTestsService.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doAnswer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.budget.repository.BudgetRepository;
import com.budgetplanner.commontests.budget.BudgetForTestsService;
import com.budgetplanner.domain.BudgetDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BudgetUTest {

	@MockBean
	private BudgetRepository budgetRepository;

	@Autowired
	private BudgetService budgetService;

	List<BudgetDTO> budgets;
	
	@Before
	public void setUp() {
		budgets = new ArrayList<>();
		budgets.add(validBudget());
	}
	
	@Test
	public void insertValidBudget() {
		//final List<BudgetDTO> budgets = new ArrayList<>();
		doAnswer(new Answer<List<BudgetDTO>>() {
			@Override
			public List<BudgetDTO> answer(InvocationOnMock invocation) throws Throwable {
				BudgetDTO budgetDTO = (BudgetDTO) invocation.getArguments()[0];
				budgets.add(budgetDTO);
				return budgets;
			}
		}).when(budgetRepository).insert(validBudget());
		budgetService.insert(validBudget());
		assertThat(budgets.size(), equalTo(2));
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
		budgetService.insert(BudgetForTestsService.budgetWithEmptyIncome());
	}
}
