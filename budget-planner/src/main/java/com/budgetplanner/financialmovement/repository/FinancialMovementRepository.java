package com.budgetplanner.financialmovement.repository;

import java.util.HashSet;
import java.util.Set;

import com.budgetplanner.domain.FinancialMovementDTO;

public interface FinancialMovementRepository {

	public static final Set<FinancialMovementDTO> SUBCATEGORY_DATABASE = new HashSet<>();

	void add(FinancialMovementDTO electricity);

	FinancialMovementDTO findById(Integer addedId);

}
