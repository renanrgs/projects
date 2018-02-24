package com.budgetplanner.budget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetplanner.budget.repository.BudgetRepository;
import com.budgetplanner.domain.BudgetDTO;

@Service
public class BudgetServiceImpl implements BudgetService {

	@Autowired
	private BudgetRepository budgetRepository;
	
	@Override
	public void insert(BudgetDTO budget) {
		validate(budget);
	}

	private void validate(BudgetDTO budget) {
		if(budget == null ) throw new IllegalArgumentException();
	}

}
