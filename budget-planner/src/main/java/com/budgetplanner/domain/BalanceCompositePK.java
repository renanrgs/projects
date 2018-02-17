package com.budgetplanner.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

//TODO Bidirectional relationship need to be coded.
@Embeddable
public class BalanceCompositePK implements Serializable {

	@ManyToOne
	private BudgetDTO budgetDTO;

	@ManyToOne
	private SubCategoryDTO subCategoryDTO;

}
