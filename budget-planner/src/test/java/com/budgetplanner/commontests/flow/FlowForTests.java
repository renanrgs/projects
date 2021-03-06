package com.budgetplanner.commontests.flow;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;

import com.budgetplanner.domain.FlowDTO;

@Ignore
public class FlowForTests {

	public static FlowDTO incomeFlow() {
		FlowDTO validFlow = new FlowDTO();
		validFlow.setName("Income");
		return validFlow;
	}

	public static FlowDTO flowWithNullName() {
		FlowDTO flowWithIdOne = new FlowDTO();
		flowWithIdOne.setName(null);
		return flowWithIdOne;
	}

	public static FlowDTO flowWithIncomeAsName() {
		FlowDTO validFlow = new FlowDTO();
		validFlow.setName("Income");
		return validFlow;
	}

	public static List<FlowDTO> twoValidFlow() {
		return Arrays.asList(new FlowDTO("Income"), new FlowDTO("Expense"));
	}

	public static List<FlowDTO> twoFlowWithDuplicateId() {
		return Arrays.asList(new FlowDTO("Income"), new FlowDTO("wwww"));
	}

	public static FlowDTO nullFlow() {
		return null;
	}

	public static FlowDTO flowWithEmptyName() {
		return new FlowDTO("");
	}

	public static FlowDTO expenseFlow() {
		FlowDTO validFlow = new FlowDTO();
		validFlow.setId(2);
		validFlow.setName("Expense");
		return validFlow;
	}

}
