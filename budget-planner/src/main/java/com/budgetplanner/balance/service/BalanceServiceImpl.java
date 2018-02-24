package com.budgetplanner.balance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.budgetplanner.category.constants.TypeFlow;
import com.budgetplanner.domain.BalanceDTO;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.FinancialMovementDTO;

@Service
public class BalanceServiceImpl implements BalanceService {

	@Override
	public BalanceDTO calculateTotal(List<FinancialMovementDTO> financialMovements) {
		validate(budget);
		BalanceDTO balance = new BalanceDTO(budget);
		Double totalIncome = calculateTotal(financialMovements);
		Double totalExpense = calculateTotal(financialMovements);
		balance.setTotalIncome(totalIncome);
		balance.setTotalExpense(totalExpense);
		balance.setAmount(totalIncome - totalExpense);
		return balance;
	}

	private void validate(BudgetDTO budget) {
		if (budget == null) {
			throw new IllegalArgumentException();
		}
	}

	private Double calculateTotal(Set<FinancialMovementDTO> subCategory, TypeFlow flowDTO) {
		return subCategory.stream()
				.filter(sub -> sub.getId().getCategoryDTO().getFlowDTO().equals(flowDTO.getFlowDTO()))
				.reduce(0.0, (acc, sub) -> acc + sub.getAmount(), (amount1, amount2) -> amount1 + amount2);

	}

	@Override
	public List<BalanceDTO> list(List<BudgetDTO> validBudgetList) {
		List<BalanceDTO> listBalance = new ArrayList<>();
		validBudgetList.forEach((budget) -> {
			BalanceDTO balance = calculateTotal(budget);
			listBalance.add(balance);
		});
		return listBalance;
	}
}
