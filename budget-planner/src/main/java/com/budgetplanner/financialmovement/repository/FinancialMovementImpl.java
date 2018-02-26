package com.budgetplanner.financialmovement.repository;

import java.util.Optional;

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
		validate(financialMovement);
		financialMovementRepository.save(financialMovement);
	}

	private void validate(FinancialMovementDTO financialMovement) {
		Optional.ofNullable(financialMovement).orElseThrow(IllegalArgumentException::new);
		Optional.ofNullable(financialMovement.getId().getId()).orElseThrow(IllegalArgumentException::new);
		Optional.ofNullable(financialMovement.getAmount()).orElseThrow(IllegalArgumentException::new);
		Optional.ofNullable(financialMovement.getAmount()).filter(amount -> amount >= 0)
				.orElseThrow(IllegalArgumentException::new);
	}

}
