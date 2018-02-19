package com.budgetplanner.category.service;

import static com.budgetplanner.commontests.category.CategoryForTestsRepository.validCategory;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.category.repository.CategoryRepository;
import com.budgetplanner.commontests.category.CategoryForTestsRepository;
import com.budgetplanner.commontests.flow.FlowForTestsRepository;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.FlowDTO;
import com.budgetplanner.flow.repository.FlowRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryUTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Autowired
	private FlowRepository flowRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	FlowDTO validFlow;

	@Before
	public void setUp() {
		validFlow = flowRepository.save(FlowForTestsRepository.validFlow());
	}

	@Test
	public void givenAValidCategoryThenInsert() {
		CategoryDTO category = validCategory();
		category.setFlowDTO(validFlow);
		category = categoryRepository.save(category);
		assertThat(category.getId(), notNullValue());
		category = categoryRepository.findOne(category.getId());
		assertThat(category.getId(), notNullValue());
	}

	@Test
	public void givenAValidCategoryThenDelete() {
		CategoryDTO category = validCategory();
		assertThat(category.getId(), nullValue());

		category.setFlowDTO(validFlow);
		category = categoryRepository.save(category);
		assertThat(category.getId(), notNullValue());

		category = categoryRepository.findOne(category.getId());
		assertThat(category.getId(), notNullValue());

		categoryRepository.delete(category);
		category = categoryRepository.findOne(category.getId());
		assertThat(category, nullValue());
	}

	@Test
	public void givenACategoryListThenDeleteAll() {
		List<CategoryDTO> categories = CategoryForTestsRepository.validCategoryList();
		categories.forEach(c -> c.setFlowDTO(validFlow));
		categories = (List<CategoryDTO>) categoryRepository.save(categories);

		assertThat(categories.size(), equalTo(3));
		categories.forEach(c -> assertThat(c.getId(), notNullValue()));

		categories = (List<CategoryDTO>) categoryRepository.findAll();
		assertThat(categories.size(), equalTo(3));
		categoryRepository.deleteAll();
		
		categories = (List<CategoryDTO>) categoryRepository.findAll();
		assertTrue(categories.isEmpty());
	}
}
