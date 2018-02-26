package com.budgetplanner.budget.service;

import static com.budgetplanner.commontests.budget.BudgetForTestsRepository.nullBudget;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.category.service.CategoryService;
import com.budgetplanner.commontests.budget.BudgetForTestsService;
import com.budgetplanner.commontests.category.CategoryForTests;
import com.budgetplanner.commontests.financialmovement.FinancialMovementForTests;
import com.budgetplanner.commontests.flow.FlowForTests;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.FinancialMovementDTO;
import com.budgetplanner.financialmovement.service.FinancialMovementService;
import com.budgetplanner.flow.service.FlowService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BudgetServiceUTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Autowired
	private BudgetService budgetService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private FlowService flowService;

	@Autowired
	private FinancialMovementService financialMovementService;

	private Set<FinancialMovementDTO> financialMovements;

	@Before
	public void setUp() {
		if (flowService.findById(1) != null) {
			flowService.save(FlowForTests.incomeFlow());
			categoryService.save(CategoryForTests.menialJob());
			FinancialMovementDTO financialMovementDTO = FinancialMovementForTests.netSalaryFromSales();
			financialMovementService.save(financialMovementDTO);
			financialMovements = new HashSet<>();
			financialMovements.add(financialMovementDTO);
		}
	}

	@Test
	public void givenValidBudgetThenSave() {
		BudgetDTO budget = BudgetForTestsService.validBudget();
		budget.setFinancialMovements(financialMovements);
		budgetService.save(budget);
		List<BudgetDTO> budgets = budgetService.findAll();
		assertThat(budgets.size(), equalTo(1));
	}

	@Test
	public void givenANullBudgetThenThrowsException() {
		exception.expect(IllegalArgumentException.class);
		budgetService.save(nullBudget());
	}

}
