package com.budgetplanner.financialmovement.repository;

import static com.budgetplanner.commontests.financialmovement.FinancialMovementForTestsService.electricity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budgetplanner.financialmovement.repository.FinancialMovementRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinancialMovementRepositoyUTest {

	
	@Autowired
	private FinancialMovementRepository financialMovementRepository;

	@Test
	public void addNewValidSubCategoryTest() {
		financialMovementRepository.add(electricity());
	}

}
