package com.alperen.server.calculation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

	@Autowired
	private CalculationRepository calculationRepository;
	
	Calculation create(Calculation calculation) {
		calculation.setSum(calculation.getNum1()+calculation.getNum2());
		return calculationRepository.save(calculation);
	}

	public List<Calculation> getAll() {
		return calculationRepository.findAll();
	}
}
