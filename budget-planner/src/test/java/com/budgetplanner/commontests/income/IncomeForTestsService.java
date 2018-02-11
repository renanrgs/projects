package com.budgetplanner.commontests.income;

import java.util.Arrays;

import com.budgetplanner.commontests.category.CategoryForTestsService;
import com.budgetplanner.domain.IncomeDTO;

public class IncomeForTestsService {

	public static IncomeDTO oneValidIncome() {
		return new IncomeDTO(Arrays.asList(CategoryForTestsService.mainJob()));

	}
	
	public static IncomeDTO incomeWithOneInvalidCategoryType() {
		return new IncomeDTO(Arrays.asList(CategoryForTestsService.housing(), CategoryForTestsService.mainJob()));
	}

}
