package com.budgetplanner.commontests.category;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;

import com.budgetplanner.domain.CategoryDTO;

@Ignore
public class CategoryForTestsRepository {

	public static CategoryDTO validCategory() {
		CategoryDTO validCategory = new CategoryDTO();
		validCategory.setName("Main Job");
		return validCategory;
	}

	public static List<CategoryDTO> validCategoryList() {
		return Arrays.asList(new CategoryDTO("Main Job"), new CategoryDTO("Sales"), new CategoryDTO("Investments"));
	}

}
