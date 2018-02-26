package com.budgetplanner.financialmovement.service;

import static com.budgetplanner.commontests.financialmovement.FinancialMovementForTests.financialMovementIdLowerThanZero;
import static com.budgetplanner.commontests.financialmovement.FinancialMovementForTests.nullFinancialMovement;
import static com.budgetplanner.commontests.financialmovement.FinancialMovementForTests.rent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.category.service.CategoryService;
import com.budgetplanner.commontests.flow.FlowForTests;
import com.budgetplanner.flow.service.FlowService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinancialMovementServiceUTest {

	@Autowired
	private FinancialMovementService financialMovementService;

	@Autowired
	private FlowService flowService;

	@Autowired
	private CategoryService categoryService;

	@Test
	public void givenAValidFinancialMovementThenSave() {
		flowService.save(FlowForTests.incomeFlow());
		flowService.save(FlowForTests.expenseFlow());

		categoryService.save(rent().getCategoryDTO());

		financialMovementService.save(rent());
	}

	@Test(expected = IllegalArgumentException.class)
	public void givenNullFinancialMovementThenThrowsException() {
		financialMovementService.save(nullFinancialMovement());
	}

	@Test(expected = IllegalArgumentException.class)
	public void givenMovementAmountLowerThanZeroThrowsException() {
		financialMovementService.save(financialMovementIdLowerThanZero());
	}

}
