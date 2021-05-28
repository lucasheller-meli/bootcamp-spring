package com.exemplo.aula2.tarde.ex2.controllers;

import com.exemplo.aula2.tarde.ex2.entities.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @GetMapping
    public ResponseEntity<Double> totalCash() {
        return ResponseEntity.ok(Restaurant.getCash());
    }
}
