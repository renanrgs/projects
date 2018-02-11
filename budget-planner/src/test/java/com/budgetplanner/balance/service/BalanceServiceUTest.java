package com.budgetplanner.balance.service;

import static com.budgetplanner.commontests.balance.BalanceForTestsService.validBalance;
import static org.mockito.Mockito.doAnswer;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.balance.repository.BalanceRepository;
import com.budgetplanner.domain.BalanceDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BalanceServiceUTest {

	@MockBean
	private BalanceRepository balanceRepository;

	@Autowired
	private BalanceService balanceService;

	@Test
	public void insertValidBalance() {
		doAnswer(new Answer<List<BalanceDTO>>() {
			@Override
			public List<BalanceDTO> answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		}).when(balanceRepository).insert(validBalance());
		balanceService.insert(validBalance());
	}

}
