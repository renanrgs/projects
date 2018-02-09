package com.budgetplanner.subcategory.service;

import static com.budgetplanner.commontests.subcategory.SubCategoryForTestsRepository.nullSubCategory;
import static com.budgetplanner.commontests.subcategory.SubCategoryForTestsRepository.rent;
import static com.budgetplanner.commontests.subcategory.SubCategoryForTestsRepository.subCategoryIdLowerThanZero;
import static com.budgetplanner.commontests.subcategory.SubCategoryForTestsRepository.subCategoryWithIdGreaterThan200;
import static com.budgetplanner.commontests.subcategory.SubCategoryForTestsRepository.subCategoryWithNullIdAndName;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.service.SubCategoryService;
import com.budgetplanner.subcategory.repository.SubCategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubCategoryServiceUTest {
	
	@Mock
	private SubCategoryRepository subCategoryRepository;

	@Autowired
	@InjectMocks
	private SubCategoryService subCategoryService;

	@Test
	public void addNewValidSubCategoryTest() {
		when(subCategoryRepository.add(rent())).thenReturn(true);
		Boolean added = subCategoryService.add(rent());
		assertTrue(added);
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionWhenAddingNullSubCategory() {
		subCategoryService.add(nullSubCategory());
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionWhenAddingNullIdAndName() {
		subCategoryService.add(subCategoryWithNullIdAndName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionWhenIdIsLowerThanZero() {
		subCategoryService.add(subCategoryIdLowerThanZero());
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionWhenIdIsGreaterThan200() {
		subCategoryService.add(subCategoryWithIdGreaterThan200());
	}
}
