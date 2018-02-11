package com.budgetplanner.expense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetplanner.commontests.budget.ExpenseDTO;
import com.budgetplanner.expense.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService{

	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Override
	public void insert(ExpenseDTO expenseDTO) {
		expenseRepository.insert(expenseDTO);
	}
	
}
