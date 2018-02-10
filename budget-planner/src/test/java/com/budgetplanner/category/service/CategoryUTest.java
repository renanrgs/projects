package com.budgetplanner.category.service;

import static com.budgetplanner.commontests.category.CategoryForTestsService.categoryWithSubCategoryEmpty;
import static com.budgetplanner.commontests.category.CategoryForTestsService.housing;
import static com.budgetplanner.commontests.category.CategoryForTestsService.categoryWithNullSubCategory;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.category.repository.CategoryRepository;
import com.budgetplanner.domain.CategoryDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryUTest {

	@MockBean
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryService categoryService;

	@Test
	public void addNewValidCategory() {
		when(categoryRepository.add()).thenReturn(housing());
		CategoryDTO categoryDTO = categoryService.add(housing());
		assertThat(categoryDTO, notNullValue());
		assertThat(categoryDTO, equalTo(housing()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addThrowsExceptionWhenSubCategoryIsEmpty() {
		when(categoryRepository.add()).thenReturn(housing());
		categoryService.add(categoryWithSubCategoryEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void addThrowsExceptionWhenSubCategoryIsNull() {
		when(categoryRepository.add()).thenReturn(housing());
		categoryService.add(categoryWithNullSubCategory());
	}
}
