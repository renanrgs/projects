package com.budgetplanner.commontests.financialmovement;

import org.junit.Ignore;

import com.budgetplanner.commontests.category.CategoryForTestsService;
import com.budgetplanner.domain.FinancialMovementDTO;

@Ignore
public class FinancialMovementForTestsService {

	public static FinancialMovementDTO electricity() {
		FinancialMovementDTO financialMovementDTO = new FinancialMovementDTO(1, "Electricity", 100.0, CategoryForTestsService.housing());
		return financialMovementDTO;
	}

	public static FinancialMovementDTO rent() {
		return new FinancialMovementDTO(2, "Rent", 2000.0, CategoryForTestsService.housing());

	}

	public static FinancialMovementDTO administrativeFee() {
		return new FinancialMovementDTO(3, "Administrative Fee", 0.0, CategoryForTestsService.housing());
	}

	public static FinancialMovementDTO nullFinancialMovement() {
		return null;
	}

	public static FinancialMovementDTO financialMovementWithNullIdAndName() {
		return new FinancialMovementDTO(null, null, 0.0, CategoryForTestsService.housing());
	}

	public static FinancialMovementDTO financialMovementIdLowerThanZero() {
		return new FinancialMovementDTO(-2, "test", 0.0, CategoryForTestsService.housing());
	}

	public static FinancialMovementDTO financialMovementWithIdGreaterThan200() {
		return new FinancialMovementDTO(201, "test", 0.0, CategoryForTestsService.housing());

	}

	public static FinancialMovementDTO netSalaryFromCompany() {
		return new FinancialMovementDTO(4, "Net salary", 7500.0, CategoryForTestsService.mainJob());
	}

	public static FinancialMovementDTO netSalaryFromSales() {
		return new FinancialMovementDTO(4, "Net salary Sales", 3500.0, CategoryForTestsService.menialJob());
	}

}
