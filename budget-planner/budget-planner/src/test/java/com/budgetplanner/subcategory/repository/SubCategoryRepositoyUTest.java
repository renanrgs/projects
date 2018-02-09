package com.budgetplanner.subcategory.repository;

import static com.budgetplanner.commontests.subcategory.SubCategoryForTestsRepository.electricity;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.domain.SubCategoryDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubCategoryRepositoyUTest {

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Test
	public void addNewValidSubCategoryTest() {
		Boolean added = subCategoryRepository.add(electricity());
		assertTrue(added);
	}
	
	@Test
	public void addDuplicateSubCategoryTest() {
		Boolean added = subCategoryRepository.add(electricity());
		assertFalse(added);
	}

}
