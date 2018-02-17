package com.budgetplanner.financialmovement.repository;

import static com.budgetplanner.commontests.financialmovement.FinancialMovementForTestsService.electricity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.subcategory.repository.SubCategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubCategoryRepositoyUTest {

	
	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Test
	public void addNewValidSubCategoryTest() {
		subCategoryRepository.add(electricity());
	}

	@Test
	public void addDuplicateSubCategoryTest() {
		subCategoryRepository.add(electricity());
	}

}
