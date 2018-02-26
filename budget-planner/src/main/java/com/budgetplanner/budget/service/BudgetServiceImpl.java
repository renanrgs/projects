package com.budgetplanner.budget.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetplanner.budget.repository.BudgetRepository;
import com.budgetplanner.domain.BudgetDTO;

@Service
public class BudgetServiceImpl implements BudgetService {

	@Autowired
	private BudgetRepository budgetRepository;

	private void validate(BudgetDTO budget) {
		if (budget == null) {
			System.out.println("Passei aqui");
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void save(BudgetDTO budget) {
		validate(budget);
		budgetRepository.save(budget);
	}

	@Override
	public List<BudgetDTO> findAll() {
		return (List<BudgetDTO>) budgetRepository.findAll();
	}

}
