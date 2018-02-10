package com.budgetplanner.commontests.category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.SubCategoryDTO;
import static com.budgetplanner.commontests.subcategory.SubCategoryForTestsRepository.*;
public class CategoryForTestsService {

	public static CategoryDTO housing() {
		List<SubCategoryDTO> subCategories = Arrays.asList(electricity());
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", subCategories);
		
		
		return categoryDTO;
	}

	public static CategoryDTO mainJob() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "Net Salary", new ArrayList<SubCategoryDTO>());
		return categoryDTO;
	}

	public static CategoryDTO categoryWithSubCategoryEmpty() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", new ArrayList<>());
		return categoryDTO;
	}
	
	public static CategoryDTO categoryWithNullSubCategory() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", new ArrayList<>());
		return categoryDTO;
	}
	

}
