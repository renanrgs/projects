package com.budgetplanner.flow.repository;

import static com.budgetplanner.commontests.flow.FlowForTests.flowWithIncomeAsName;
import static com.budgetplanner.commontests.flow.FlowForTests.flowWithNullName;
import static com.budgetplanner.commontests.flow.FlowForTests.nullFlow;
import static com.budgetplanner.commontests.flow.FlowForTests.twoValidFlow;
import static com.budgetplanner.commontests.flow.FlowForTests.incomeFlow;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

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
		FlowDTO flowDTO = flowRepository.save(incomeFlow());
		flowDTO = flowRepository.findOne(flowDTO.getId());
		assertThat(flowDTO.getId(), notNullValue());
	}

	@Test
	public void givenAFlowWithNullNameThenThrowsException() {
		exception.expect(DataIntegrityViolationException.class);
		flowRepository.save(flowWithNullName());
	}

	@Test
	public void givenADuplicateFlowNameThenThrowsException() {
		exception.expect(DataIntegrityViolationException.class);
		flowRepository.save(flowWithIncomeAsName());
		flowRepository.save(flowWithIncomeAsName());
	}

	@Test
	public void givenAValidFlowListThenInsertAll() {
		flowRepository.save(twoValidFlow());
		List<FlowDTO> allFlows = (List<FlowDTO>) flowRepository.findAll();
		assertThat(allFlows.size(), equalTo(2));
	}

	@Test
	public void givenAValidFlowThenDelete() {
		FlowDTO flow = incomeFlow();
		assertThat(flow.getId(), nullValue());
		flow = flowRepository.save(flow);
		assertThat(flow.getId(), notNullValue());
		flowRepository.delete(flow);
		flow = flowRepository.findOne(flow.getId());
		assertThat(flow, nullValue());
	}

	@Test
	public void givenANullFlowThrowsException() {
		exception.expect(InvalidDataAccessApiUsageException.class);
		flowRepository.save(nullFlow());
	}

}
