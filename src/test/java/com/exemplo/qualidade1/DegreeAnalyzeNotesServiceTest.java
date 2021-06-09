package com.exemplo.qualidade1;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DegreeAnalyzeNotesServiceTest {
    private static final String FAILED_MESSAGE = "Unfortunately you have failed this semester.";
    private static final String CONGRATULATIONS_MESSAGE = "Congratulations, you have learned everything that this semester had to offer!";
    private static final String APPROVED_MESSAGE = "You have been approved.";

    private final DegreeAnalyzeNotesService degreeAnalyzeNotesService;

    public DegreeAnalyzeNotesServiceTest() {
        this.degreeAnalyzeNotesService = new DegreeAnalyzeNotesService();
    }

    @Test
    void whenCallingGenerateDegreeWhereAverageIsLowerThan6ItShouldReturnAverageWithFailedMessage() {
        Subject mathematics = Subject.builder().name("mathematics").grade(5).build();
        Subject portuguese = Subject.builder().name("portuguese").grade(4).build();
        Student student = Student.builder().name("rodrigomoraes").subjects(List.of(mathematics, portuguese)).build();

        Degree expectedDegree = Degree.builder().average(4.5).message(FAILED_MESSAGE).student(student).build();
        Degree actualDegree = degreeAnalyzeNotesService.generateDegree(student);

        assertEquals(expectedDegree, actualDegree);
    }

    @Test
    void whenCallingGenerateDegreeWhereAverageIsBetween6And9ItShouldReturnAverageWithApprovedMessage() {
        Subject mathematics = Subject.builder().name("mathematics").grade(6).build();
        Subject portuguese = Subject.builder().name("portuguese").grade(4).build();
        Subject sciences = Subject.builder().name("sciences").grade(8).build();
        Student student = Student.builder().name("rodrigomoraes").subjects(List.of(mathematics, portuguese, sciences)).build();

        Degree expectedDegree = Degree.builder().average(6.0).message(APPROVED_MESSAGE).student(student).build();
        Degree actualDegree = degreeAnalyzeNotesService.generateDegree(student);

        assertEquals(expectedDegree, actualDegree);
    }

    @Test
    void whenCallingGenerateDegreeWhereAverageIsAbove9ItShouldReturnAverageWithFailedMessage() {
        Subject mathematics = Subject.builder().name("mathematics").grade(10).build();
        Subject portuguese = Subject.builder().name("portuguese").grade(10).build();
        Subject sciences = Subject.builder().name("sciences").grade(9).build();
        Subject programming = Subject.builder().name("programming").grade(10).build();
        Student student = Student.builder().name("rodrigomoraes").subjects(List.of(mathematics, portuguese, sciences, programming)).build();

        Degree expectedDegree = Degree.builder().average(9.75).message(CONGRATULATIONS_MESSAGE).student(student).build();
        Degree actualDegree = degreeAnalyzeNotesService.generateDegree(student);

        assertEquals(expectedDegree, actualDegree);
    }
}