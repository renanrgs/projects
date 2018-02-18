package com.budgetplanner.flow.repository;

import static com.budgetplanner.commontests.flow.FlowForTestsRepository.validFlow;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.domain.FlowDTO;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FlowRepositoryUTest {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	private FlowRepository flowRepository;

	@Test
	public void givenAValidFlowThenInsert() {
		entityManager.persistAndFlush(validFlow());
		FlowDTO flowDTO = flowRepository.findOne(1);
		assertThat(flowDTO, notNullValue());
	}
}
