package com.exemplo.aula2.tarde.ex1;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DegreeServiceTest {

    @Test
    void tresDisciplinaCorretamenteAprovadoPass(){

        //arrange
        Subject expectSub1 = Subject.builder().grade(7.0).name("Matematica").build();
        Subject exceptSub2 = Subject.builder().grade(7.0).name("Portugues").build();
        Subject exceptSub3 = Subject.builder().grade(7.0).name("Fisica").build();

        Student expectStudent = Student.builder().name("Maria").subjects(Arrays.asList(expectSub1, exceptSub2, exceptSub3)).build();
        Degree expectDegree = Degree.builder().student(expectStudent).average(7.0).message("You have been approved.").build();

        Subject sub1 = Subject.builder().grade(7.0).name("Matematica").build();
        Subject sub2 = Subject.builder().grade(7.0).name("Portugues").build();
        Subject sub3 = Subject.builder().grade(7.0).name("Fisica").build();
        Student student = Student.builder().name("Maria").subjects(Arrays.asList(sub1, sub2, sub3)).build();
        DegreeService degreeService = new DegreeService();

        //act
        Degree degree = degreeService.generateDegree(student);

        //assert
        assertEquals(expectDegree, degree);
    }

    @Test
    void tresDisciplinaCorretamenteMeritoPass(){

        //arrange
        Subject expectSub1 = Subject.builder().grade(10.0).name("Matematica").build();
        Subject exceptSub2 = Subject.builder().grade(10.0).name("Portugues").build();
        Subject exceptSub3 = Subject.builder().grade(10.0).name("Fisica").build();

        Student expectStudent = Student.builder().name("Maria").subjects(Arrays.asList(expectSub1, exceptSub2, exceptSub3)).build();
        Degree expectDegree = Degree.builder().student(expectStudent).average(10.0).message("Congratulations, you have learned everything that this semester had to offer!").build();

        Subject sub1 = Subject.builder().grade(10.0).name("Matematica").build();
        Subject sub2 = Subject.builder().grade(10.0).name("Portugues").build();
        Subject sub3 = Subject.builder().grade(10.0).name("Fisica").build();
        Student student = Student.builder().name("Maria").subjects(Arrays.asList(sub1, sub2, sub3)).build();
        DegreeService degreeService = new DegreeService();

        //act
        Degree degree = degreeService.generateDegree(student);

        //assert
        assertEquals(expectDegree, degree);
    }

    @Test
    void tresDisciplinaCorretamenteReprovadoPass(){

        //arrange
        Subject expectSub1 = Subject.builder().grade(5.0).name("Matematica").build();
        Subject exceptSub2 = Subject.builder().grade(5.0).name("Portugues").build();
        Subject exceptSub3 = Subject.builder().grade(5.0).name("Fisica").build();

        Student expectStudent = Student.builder().name("Maria").subjects(Arrays.asList(expectSub1, exceptSub2, exceptSub3)).build();
        Degree expectDegree = Degree.builder().student(expectStudent).average(5.0).message("Unfortunately you have failed this semester.").build();

        Subject sub1 = Subject.builder().grade(5.0).name("Matematica").build();
        Subject sub2 = Subject.builder().grade(5.0).name("Portugues").build();
        Subject sub3 = Subject.builder().grade(5.0).name("Fisica").build();
        Student student = Student.builder().name("Maria").subjects(Arrays.asList(sub1, sub2, sub3)).build();
        DegreeService degreeService = new DegreeService();

        //act
        Degree degree = degreeService.generateDegree(student);

        //assert
        assertEquals(expectDegree, degree);
    }

    @Test
    void tresDisciplinaCorretamenteNotPass(){

        //arrange
        Subject expectSub1 = Subject.builder().grade(7.0).name("Matematica").build();
        Subject exceptSub2 = Subject.builder().grade(7.0).name("Portugues").build();
        Subject exceptSub3 = Subject.builder().grade(7.0).name("Fisica Moderna").build();

        Student expectStudent = Student.builder().name("Maria").subjects(Arrays.asList(expectSub1, exceptSub2, exceptSub3)).build();
        Degree expectDegree = Degree.builder().student(expectStudent).average(7.0).message("Failled.").build();

        Subject sub1 = Subject.builder().grade(7.0).name("Matematica").build();
        Subject sub2 = Subject.builder().grade(7.0).name("Portugues").build();
        Subject sub3 = Subject.builder().grade(7.0).name("Fisica Moderna").build();
        Student student = Student.builder().name("Maria").subjects(Arrays.asList(sub1, sub2, sub3)).build();
        DegreeService degreeService = new DegreeService();

        //act
        Degree degree = degreeService.generateDegree(student);

        //assert
        assertNotEquals(expectDegree, degree);
    }

    @Test
    void semNomeTresDisciplinasCorretamenteNaoPassa(){
        //arrange
        Subject sub1 = Subject.builder().grade(7.0).name("Matematica").build();
        Subject sub2 = Subject.builder().grade(7.0).name("Portugues").build();
        Subject sub3 = Subject.builder().grade(7.0).name("Fisica Moderna").build();

        Student student = Student.builder().name("M").subjects(Arrays.asList(sub1, sub2, sub3)).build();

        //act
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        //assert
        assertEquals(1, violations.size());
    }

    @Test
    void alunoVazioReprovado(){
        //arrange
        Student student = Student.builder().name("Marianne").subjects(Collections.emptyList()).build();

        //act
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        //assert
        assertEquals(1, violations.size());
    }

}