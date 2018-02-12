package com.budgetplanner.income.service;

import static com.budgetplanner.commontests.income.IncomeForTestsService.*;
import static com.budgetplanner.commontests.income.IncomeForTestsService.oneValidIncome;
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

import com.budgetplanner.domain.IncomeDTO;
import com.budgetplanner.income.repository.IncomeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IncomeServiceUTest {

	@MockBean
	private IncomeRepository incomeRepository;

	@Autowired
	private IncomeService incomeService;

	private List<IncomeDTO> incomes;

	@Before
	public void setUp() {
		incomes = new ArrayList<>();
	}

	@Test
	public void insertOneValidIncome() {
		doAnswer(new Answer<List<IncomeDTO>>() {
			@Override
			public List<IncomeDTO> answer(InvocationOnMock invocation) throws Throwable {
				IncomeDTO incomeDTO = (IncomeDTO) invocation.getArguments()[0];
				incomes.add(incomeDTO);
				return incomes;
			}
		}).when(incomeRepository).insert(oneValidIncome());
		incomeService.insert(oneValidIncome());
		assertThat(incomes.size(), equalTo(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void insertThrowsExceptionWhenOneCategoryIsInvalid() {
		incomeService.insert(incomeWithOneInvalidCategoryType());
	}

	@Test(expected = IllegalArgumentException.class)
	public void insertThrowsExcepionWhenSubCategoryLowerThanZero() {
		incomeService.insert(incomeWithSubCategoryLowerThanZero());
	}
}
