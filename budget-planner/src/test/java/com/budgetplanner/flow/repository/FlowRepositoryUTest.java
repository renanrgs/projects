package com.budgetplanner.flow.repository;

import static com.budgetplanner.commontests.flow.FlowForTestsRepository.flowWithNullName;
import static com.budgetplanner.commontests.flow.FlowForTestsRepository.validFlow;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.commontests.flow.FlowForTestsRepository;
import com.budgetplanner.domain.FlowDTO;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FlowRepositoryUTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Autowired
	private FlowRepository flowRepository;

	@Test
	public void givenAValidFlowThenInsert() {
		flowRepository.save(validFlow());
		FlowDTO flowDTO = flowRepository.findOne(1);
		assertThat(flowDTO, notNullValue());
	}

	@Test
	public void givenAFlowWithNullNameThenThrowsException() {
		exception.expect(DataIntegrityViolationException.class);
		flowRepository.save(flowWithNullName());
	}

	@Test
	public void givenADuplicateFlowNameThenThrowsException() {
		exception.expect(DataIntegrityViolationException.class);
		flowRepository.save(FlowForTestsRepository.flowWithIncomeAsName());
		flowRepository.save(FlowForTestsRepository.flowWithIncomeAsName());
	}

	@Test
	public void givenAValidFlowListThenInsertAll() {
		flowRepository.save(FlowForTestsRepository.twoValidFlow());
		List<FlowDTO> allFlows = (List<FlowDTO>) flowRepository.findAll();
		assertThat(allFlows.size(), equalTo(2));
	}

}
