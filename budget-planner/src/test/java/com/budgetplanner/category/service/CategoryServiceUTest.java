package com.budgetplanner.category.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.commontests.category.CategoryForTests;
import com.budgetplanner.commontests.flow.FlowForTests;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.flow.service.FlowService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceUTest {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private FlowService flowService;

	@Test
	public void givenValidCategoryThenSave() {
		flowService.save(FlowForTests.incomeFlow());
		CategoryDTO categoryDTO = CategoryForTests.menialJob();
		categoryService.save(categoryDTO);
		List<CategoryDTO> categories = categoryService.findAll();
		assertThat(categories.size(), equalTo(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void givenNullCategoryThrowsException() {
		categoryService.save(CategoryForTests.nullCategory());
	}

	@Test(expected = IllegalArgumentException.class)
	public void givenCategoryWithNullNameTheThrowsException() {
		categoryService.save(CategoryForTests.categoryWithNullName());
	}

}
