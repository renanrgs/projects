package com.budgetplanner.category.service;

import static com.budgetplanner.commontests.category.CategoryForTestsRepository.validCategory;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.category.repository.CategoryRepository;
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
		
	}
}
