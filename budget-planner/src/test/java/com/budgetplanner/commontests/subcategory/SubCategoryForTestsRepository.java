package com.budgetplanner.commontests.subcategory;

import org.junit.Ignore;

import com.budgetplanner.domain.SubCategoryDTO;

@Ignore
public class SubCategoryForTestsRepository {

	public static SubCategoryDTO electricity() {
		return new SubCategoryDTO(1, "Electricity", 0.0);
	}

	public static SubCategoryDTO rent() {
		return new SubCategoryDTO(2, "Rent", 0.0);

	}

	public static SubCategoryDTO administrativeFee() {
		return new SubCategoryDTO(3, "Administrative Fee", 0.0);
	}

	public static SubCategoryDTO nullSubCategory() {
		return null;
	}
	
	public static SubCategoryDTO subCategoryWithNullIdAndName() {
		return new SubCategoryDTO(null, null, 0.0);
	}
	
	public static SubCategoryDTO subCategoryIdLowerThanZero() {
		return new SubCategoryDTO(-2, "test", 0.0);
	}
	
	public static SubCategoryDTO subCategoryWithIdGreaterThan200() {
		return new SubCategoryDTO(201, "test", 0.0);

	}
}
