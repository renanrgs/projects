package com.budgetplanner.subcategory.repository;

import static com.budgetplanner.commontests.subcategory.SubCategoryForTestsRepository.electricity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
