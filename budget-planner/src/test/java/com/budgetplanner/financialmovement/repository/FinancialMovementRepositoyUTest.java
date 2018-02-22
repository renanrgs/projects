package com.budgetplanner.financialmovement.repository;

import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.budget.repository.BudgetRepository;
import com.budgetplanner.category.repository.CategoryRepository;
import com.budgetplanner.commontests.budget.BudgetForTests;
import com.budgetplanner.commontests.category.CategoryForTests;
import com.budgetplanner.commontests.financialmovement.FinancialMovementForTests;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.FinancialMovementDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinancialMovementRepositoyUTest {

	@Autowired
	private FinancialMovementRepository financialMovementRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BudgetRepository budgetRepository;

	Set<BudgetDTO> budgets;

	CategoryDTO mainJob;

	@Before
	public void setUp() {
		mainJob = categoryRepository.save(CategoryForTests.mainJob());
		budgetRepository.save(BudgetForTests.validBudget());
		budgets = new HashSet<>();
		budgetRepository.findAll().forEach(budget -> budgets.add(budget));
	}

	@Test
	public void givenAValidFinancialMovementThenSave() {
		FinancialMovementDTO financialMovement = FinancialMovementForTests.validFinancialMovement();
		financialMovement.setBudgets(budgets);
		financialMovement.setCategoryDTO(mainJob);
		financialMovementRepository.save(financialMovement);
		List<FinancialMovementDTO> movements = (List<FinancialMovementDTO>) financialMovementRepository.findAll();
		assertThat(movements.size(), equalTo(1));
	}

}
