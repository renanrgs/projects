package com.budgetplanner.flow.service;

import static org.junit.Assert.assertThat;

import org.junit.Rule;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.commontests.flow.FlowForTests;

import static com.budgetplanner.commontests.flow.FlowForTests.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlowServiceUTest {

	@Autowired
	private FlowService flowService;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void givenAValidFlowThenSave() {
		flowService.save(incomeFlow());
		assertThat(flowService.findAll().size(), equalTo(1));
	}

	@Test
	public void givenANullFlowToSaveThenThrowsException() {
		exception.expect(IllegalArgumentException.class);
		flowService.save(nullFlow());
	}

	@Test
	public void givenAFlowWithNullNameThrowsException() {
		exception.expect(IllegalArgumentException.class);
		flowService.save(FlowForTests.flowWithNullName());
	}

	@Test
	public void givenAFlowWithEmptyNameThrowsException() {
		exception.expect(IllegalArgumentException.class);
		flowService.save(FlowForTests.flowWithEmptyName());
	}
	
	@Test
	public void deleteAllFlow() {
		flowService.save(incomeFlow());
		assertThat(flowService.findAll().size(), equalTo(1));
		flowService.deleteAll();
		assertThat(flowService.findAll().size(), equalTo(0));
	}
}
