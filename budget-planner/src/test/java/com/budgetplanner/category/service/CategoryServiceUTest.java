package com.budgetplanner.category.service;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.commontests.category.CategoryForTests;
import com.budgetplanner.domain.CategoryDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceUTest {

	@Autowired
	private CategoryService categoryService;

	@Before
	public void setUp() {
		// validFlow = flowRepository.save(FlowForTestsRepository.validFlow());
	}

	@Test
	public void addNewValidCategory() {
		CategoryDTO categoryDTO = CategoryForTests.mainJob();
		assertThat(categoryDTO.getId(), nullValue());
		categoryService.save(categoryDTO);
		List<CategoryDTO> categories = categoryService.findAll();
		assertThat(categories.size(), CoreMatchers.equalTo(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void givenNullCategoryThrowsException() {
		categoryService.save(CategoryForTests.nullCategory());
	}

	@Test(expected = IllegalArgumentException.class)
	public void givenCategoryWithNullName() {
		categoryService.save(CategoryForTests.categoryWithNullName());
	}

}
