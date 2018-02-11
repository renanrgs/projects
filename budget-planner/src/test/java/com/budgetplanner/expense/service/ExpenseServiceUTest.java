package com.budgetplanner.expense.service;

import static com.budgetplanner.commontests.expense.ExpenseForTestsService.expenseWithOneInvalidCategoryType;
import static com.budgetplanner.commontests.expense.ExpenseForTestsService.oneValidExpense;
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

import com.budgetplanner.commontests.budget.ExpenseDTO;
import com.budgetplanner.expense.repository.ExpenseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpenseServiceUTest {

	@MockBean
	private ExpenseRepository expenseRepository;

	@Autowired
	private ExpenseService expenseService;

	private List<ExpenseDTO> expenses;

	@Before
	public void setUp() {
		expenses = new ArrayList<>();
	}

	@Test
	public void insertOneValidExpense() {
		doAnswer(new Answer<List<ExpenseDTO>>() {
			@Override
			public List<ExpenseDTO> answer(InvocationOnMock invocation) throws Throwable {
				ExpenseDTO expense = (ExpenseDTO) invocation.getArguments()[0];
				expenses.add(expense);
				return expenses;
			}
		}).when(expenseRepository).insert(oneValidExpense());
		expenseService.insert(oneValidExpense());
		assertThat(expenses.size(), equalTo(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void insertThrowsExceptionWhenOneCategoryIsInvalid() {
		expenseService.insert(expenseWithOneInvalidCategoryType());
	}

}
