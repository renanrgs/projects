package com.budgetplanner.commontests.subcategory;

import org.junit.Ignore;

import com.budgetplanner.domain.SubCategoryDTO;

@Ignore
public class SubCategoryForTestsRepository {

	public static SubCategoryDTO electricity() {
		return new SubCategoryDTO(1, "Electricity", 100.0);
	}
}
