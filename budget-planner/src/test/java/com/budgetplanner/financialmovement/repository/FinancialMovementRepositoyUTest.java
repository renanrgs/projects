package com.budgetplanner.financialmovement.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.budget.repository.BudgetRepository;
import com.budgetplanner.category.repository.CategoryRepository;
import com.budgetplanner.commontests.budget.BudgetForTestsRepository;
import com.budgetplanner.commontests.category.CategoryForTests;
import com.budgetplanner.commontests.financialmovement.FinancialMovementForTests;
import com.budgetplanner.commontests.flow.FlowForTests;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.FinancialMovementDTO;
import com.budgetplanner.domain.FlowDTO;
import com.budgetplanner.flow.repository.FlowRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FinancialMovementRepositoyUTest {

	@Autowired
	private FinancialMovementRepository financialMovementRepository;

	@Autowired
	private FlowRepository flowRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BudgetRepository budgetRepository;

	private Set<BudgetDTO> budgets;

	private CategoryDTO mainJob;

	private FlowDTO incomeFlow;

	@Before
	public void setUp() {
		incomeFlow = flowRepository.save(FlowForTests.incomeFlow());
		mainJob = CategoryForTests.mainJob();
		mainJob.setFlowDTO(incomeFlow);
		categoryRepository.save(mainJob);
		budgetRepository.save(BudgetForTestsRepository.validBudget());
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
