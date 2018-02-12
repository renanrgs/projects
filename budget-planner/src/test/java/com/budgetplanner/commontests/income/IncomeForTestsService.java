package com.budgetplanner.commontests.income;

import java.util.Arrays;

import org.junit.Ignore;

import com.budgetplanner.commontests.category.CategoryForTestsService;
import com.budgetplanner.domain.IncomeDTO;

@Ignore
public class IncomeForTestsService {

	public static IncomeDTO oneValidIncome() {
		return new IncomeDTO(Arrays.asList(CategoryForTestsService.mainJob()));

	}
	
	public static IncomeDTO incomeWithOneInvalidCategoryType() {
		return new IncomeDTO(Arrays.asList(CategoryForTestsService.housing(), CategoryForTestsService.mainJob()));
	}
	
	public static IncomeDTO incomeWithSubCategoryLowerThanZero() {
		return new IncomeDTO(Arrays.asList(CategoryForTestsService.incomeCategoryWithSubCategoryLowerThanZero()));
	}

}
