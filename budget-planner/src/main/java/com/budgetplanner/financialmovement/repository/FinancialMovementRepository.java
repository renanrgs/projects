package com.budgetplanner.financialmovement.repository;

import org.springframework.data.repository.CrudRepository;

import com.budgetplanner.domain.FinancialMovementCompositePK;
import com.budgetplanner.domain.FinancialMovementDTO;

public interface FinancialMovementRepository
		extends CrudRepository<FinancialMovementDTO, FinancialMovementCompositePK> {

}
