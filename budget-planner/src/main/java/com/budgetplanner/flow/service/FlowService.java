package com.budgetplanner.flow.service;

import java.util.List;

import com.budgetplanner.domain.FlowDTO;

public interface FlowService {

	void save(FlowDTO validFlow);

	List<FlowDTO> findAll();

}
