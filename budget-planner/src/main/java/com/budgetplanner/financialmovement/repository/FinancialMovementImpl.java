package com.budgetplanner.financialmovement.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetplanner.domain.FinancialMovementDTO;
import com.budgetplanner.financialmovement.service.FinancialMovementService;

@Service
public class FinancialMovementImpl implements FinancialMovementService {

	@Autowired
	private FinancialMovementRepository financialMovementRepository;

	@Override
	public void save(FinancialMovementDTO financialMovement) {
		financialMovementRepository.save(financialMovement);
	}

}
