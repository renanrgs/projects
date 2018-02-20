package com.budgetplanner.flow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetplanner.domain.FlowDTO;
import com.budgetplanner.flow.repository.FlowRepository;

@Service
public class FlowServiceImpl implements FlowService {

	@Autowired
	private FlowRepository flowRepository;

	@Override
	public void save(FlowDTO flowDTO) {
		validate(flowDTO);
		flowRepository.save(flowDTO);
	}

	@Override
	public List<FlowDTO> findAll() {
		return (List<FlowDTO>) flowRepository.findAll();
	}

	private void validate(FlowDTO flowDTO) {
		Optional.ofNullable(flowDTO).orElseThrow(IllegalArgumentException::new);
		Optional.ofNullable(flowDTO.getName()).orElseThrow(IllegalArgumentException::new);
		Optional.of(flowDTO.getName()).filter((name) -> !name.isEmpty()).orElseThrow(IllegalArgumentException::new);
	}
}
