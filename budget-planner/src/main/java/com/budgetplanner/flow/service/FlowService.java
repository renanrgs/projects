package com.budgetplanner.flow.service;

import java.util.List;

import com.budgetplanner.domain.FlowDTO;

public interface FlowService {

	void save(FlowDTO validFlow);

	List<FlowDTO> findAll();

	void deleteAll();

	FlowDTO findById(Integer id);

}
