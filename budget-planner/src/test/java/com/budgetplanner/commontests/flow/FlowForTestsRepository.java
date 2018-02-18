package com.budgetplanner.commontests.flow;

import org.junit.Ignore;

import com.budgetplanner.domain.FlowDTO;

@Ignore
public class FlowForTestsRepository {

	public static FlowDTO validFlow() {
		FlowDTO validFlow = new FlowDTO();
		validFlow.setName("Income");
		return validFlow;
	}
}
