package com.alperen.server.calculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/calculations")
public class CalculationController {
	
	@Autowired
	private CalculationService calculationService;

	@PostMapping
	long create(@RequestBody Calculation calculation) {
		calculation = calculationService.create(calculation);
		return calculation.getSum();
	}
	
}
