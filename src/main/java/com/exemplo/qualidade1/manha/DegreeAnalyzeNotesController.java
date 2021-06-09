package com.exemplo.qualidade1.manha;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/degree")
public class DegreeAnalyzeNotesController {
    private final DegreeAnalyzeNotesService degreeAnalyzeNotesService;

    @PostMapping("/analyzeNotes")
    public ResponseEntity<Degree> generateDegree(@RequestBody @Valid Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(degreeAnalyzeNotesService.generateDegree(student));
    }
}
