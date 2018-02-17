package com.budgetplanner.category.constants;

import com.budgetplanner.domain.FlowDTO;

public enum TypeFlow {
	INCOME(new FlowDTO(1, "Income")), EXPENSE(new FlowDTO(2, "Expense"));

	private FlowDTO flowDTO;

	private TypeFlow(FlowDTO flowDTO) {
		this.flowDTO = flowDTO;
	}

	public FlowDTO getFlowDTO() {
		return this.flowDTO;
	}
}
