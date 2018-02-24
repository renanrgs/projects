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
	public BalanceDTO calculateTotal(BudgetDTO budget) {
		validate(budget);
		BalanceDTO balance = new BalanceDTO(budget);
		Double totalIncome = calculateTotal(budget.getFinancialMovements(), TypeFlow.INCOME);
		Double totalExpense = calculateTotal(budget.getFinancialMovements(), TypeFlow.EXPENSE);
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

	private Double calculateTotal(Set<FinancialMovementDTO> financialMovements, TypeFlow flowDTO) {
		return financialMovements.stream().peek(System.out::println).peek((f -> System.out.println(f.getId().getCategoryDTO().getFlowDTO())))
				.filter(financialMovement -> financialMovement.getId().getCategoryDTO().getFlowDTO().equals(flowDTO.getFlowDTO())).peek(System.out::println)
				.reduce(0.0, (acc, financialMovement) -> acc + financialMovement.getAmount(), (amount1, amount2) -> amount1 + amount2);

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
