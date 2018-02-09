package com.budgetplanner.subcategory.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static com.budgetplanner.commontests.subcategory.SubCategoryForTestsRepository.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.hamcrest.CoreMatchers;

import com.budgetplanner.service.SubCategoryService;
import com.budgetplanner.service.SubCategoryServiceFacadeImpl;
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
