package com.exemplo.aula3.manha.ex1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloriesCalculatorController {
    private final CaloriesCalculatorService caloriesCalculatorService;

    public CaloriesCalculatorController(CaloriesCalculatorService caloriesCalculatorService) {
        this.caloriesCalculatorService = caloriesCalculatorService;
    }

    @PostMapping("/calories")
    public ResponseEntity<CaloriesCalculatorResponse> calculateCalories(@RequestBody Food food) {
        return ResponseEntity.ok(caloriesCalculatorService.calculateCalories(food));
    }
}
