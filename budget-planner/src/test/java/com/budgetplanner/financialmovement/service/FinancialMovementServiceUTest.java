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
	public void saveNewValidSubCategoryTest() {
		subCategoryService.save(rent());
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionWhensaveingNullSubCategory() {
		subCategoryService.save(nullFinancialMovement());
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionWhensaveingNullIdAndName() {
		subCategoryService.save(financialMovementWithNullIdAndName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionWhenIdIsLowerThanZero() {
		subCategoryService.save(financialMovementIdLowerThanZero());
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionWhenIdIsGreaterThan200() {
		subCategoryService.save(financialMovementWithIdGreaterThan200());
	}
}
