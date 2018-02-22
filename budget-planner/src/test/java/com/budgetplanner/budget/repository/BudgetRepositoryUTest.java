package com.budgetplanner.budget.repository;

import static org.junit.Assert.assertThat;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.commontests.budget.BudgetForTests;
import com.budgetplanner.domain.BudgetDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BudgetRepositoryUTest {

	@Autowired
	private BudgetRepository budgetRepository;

	@Test
	public void givenValidBudgetThenInsert() {
		budgetRepository.save(BudgetForTests.validBudget());
		List<BudgetDTO> budgets = (List<BudgetDTO>) budgetRepository.findAll();
		assertThat(budgets.size(), equalTo(1));
	}

}
