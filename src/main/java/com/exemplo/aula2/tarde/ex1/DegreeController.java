package com.exemplo.aula2.tarde.ex1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/degree")
public class DegreeController {
    private final DegreeService degreeService;

    @PostMapping
    public ResponseEntity<Degree> generateDegree(@Valid @RequestBody Student student) {
        return ResponseEntity.ok(degreeService.generateDegree(student));
    }
}
