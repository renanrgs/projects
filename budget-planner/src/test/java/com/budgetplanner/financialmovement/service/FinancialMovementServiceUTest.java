package com.budgetplanner.financialmovement.service;

import static com.budgetplanner.commontests.financialmovement.FinancialMovementForTests.financialMovementIdLowerThanZero;
import static com.budgetplanner.commontests.financialmovement.FinancialMovementForTests.financialMovementWithIdGreaterThan200;
import static com.budgetplanner.commontests.financialmovement.FinancialMovementForTests.financialMovementWithNullIdAndName;
import static com.budgetplanner.commontests.financialmovement.FinancialMovementForTests.nullFinancialMovement;
import static com.budgetplanner.commontests.financialmovement.FinancialMovementForTests.rent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.financialmovement.repository.FinancialMovementRepository;
import com.budgetplanner.financialmovement.service.FinancialMovementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinancialMovementServiceUTest {

	@Mock
	private FinancialMovementRepository subCategoryRepository;

	@Autowired
	@InjectMocks
	private FinancialMovementService subCategoryService;

	@Test
	public void addNewValidSubCategoryTest() {
		subCategoryService.add(rent());
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionWhenAddingNullSubCategory() {
		subCategoryService.add(nullFinancialMovement());
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionWhenAddingNullIdAndName() {
		subCategoryService.add(financialMovementWithNullIdAndName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionWhenIdIsLowerThanZero() {
		subCategoryService.add(financialMovementIdLowerThanZero());
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionWhenIdIsGreaterThan200() {
		subCategoryService.add(financialMovementWithIdGreaterThan200());
	}
}
