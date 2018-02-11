package com.budgetplanner.balance.service;

import static com.budgetplanner.commontests.balance.BalanceForTestsService.validBalanceWithValidBudget;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.domain.BalanceDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BalanceServiceUTest {

	//@MockBean
	//private BalanceRepository balanceRepository;

	@Autowired
	private BalanceService balanceService;

	
	@Test
	public void calculateMonthlyBalanceWithValidBudget() {
		BalanceDTO balanceDTO = balanceService.calculate(validBalanceWithValidBudget());
	}

}
