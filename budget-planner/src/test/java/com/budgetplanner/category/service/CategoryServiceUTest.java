package com.budgetplanner.category.service;

import static com.budgetplanner.commontests.category.CategoryForTestsService.expenseCategoryWithNullSubCategory;
import static com.budgetplanner.commontests.category.CategoryForTestsService.expenseCategoryWithSubCategoryEmpty;
import static com.budgetplanner.commontests.category.CategoryForTestsService.housing;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

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
public class CategoryServiceUTest {

	@MockBean
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryService categoryService;

	@Test
	public void addNewValidCategory() {
		CategoryDTO categoryDTO = categoryService.add(housing());
		assertThat(categoryDTO, notNullValue());
		assertThat(categoryDTO, equalTo(housing()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addThrowsExceptionWhenFlowIsNull() {
		categoryService.add(expenseCategoryWithSubCategoryEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void addThrowsExceptionWhenSubCategoryIsNull() {
		categoryService.add(expenseCategoryWithNullSubCategory());
	}
	
}
