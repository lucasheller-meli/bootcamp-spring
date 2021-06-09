package com.exemplo.qualidade1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class DegreeAnalyzeNotesControllerTest {
    private static final String FAILED_MESSAGE = "Unfortunately you have failed this semester.";
    private static final String CONGRATULATIONS_MESSAGE = "Congratulations, you have learned everything that this semester had to offer!";
    private static final String APPROVED_MESSAGE = "You have been approved.";

    private final DegreeAnalyzeNotesController degreeAnalyzeNotesController;

    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    public DegreeAnalyzeNotesControllerTest() {
        this.degreeAnalyzeNotesController = new DegreeAnalyzeNotesController(new DegreeAnalyzeNotesService());
    }

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(degreeAnalyzeNotesController).build();
    }

    @Test
    void whenCallingPostWhereAverageIsLowerThan6ItShouldReturnAverageWithFailedMessage() throws Exception {
        Subject mathematics = Subject.builder().name("mathematics").grade(5).build();
        Subject portuguese = Subject.builder().name("portuguese").grade(4).build();
        Student student = Student.builder().name("rodrigomoraes").subjects(List.of(mathematics, portuguese)).build();

        mockMvc.perform(post("/degree/analyzeNotes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(student)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.average", is(4.5)))
                .andExpect(jsonPath("$.message", is(FAILED_MESSAGE)));

    }

    @Test
    void whenCallingPostWhereAverageIsBetween6And9ItShouldReturnAverageWithApprovedMessage() throws Exception {
        Subject mathematics = Subject.builder().name("mathematics").grade(6).build();
        Subject portuguese = Subject.builder().name("portuguese").grade(4).build();
        Subject sciences = Subject.builder().name("sciences").grade(8).build();
        Student student = Student.builder().name("rodrigomoraes").subjects(List.of(mathematics, portuguese, sciences)).build();

        mockMvc.perform(post("/degree/analyzeNotes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(student)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.average", is(6.0)))
                .andExpect(jsonPath("$.message", is(APPROVED_MESSAGE)));
    }

    @Test
    void whenCallingPostWhereAverageIsAbove9ItShouldReturnAverageWithFailedMessage() throws Exception {
        Subject mathematics = Subject.builder().name("mathematics").grade(10).build();
        Subject portuguese = Subject.builder().name("portuguese").grade(10).build();
        Subject sciences = Subject.builder().name("sciences").grade(9).build();
        Subject programming = Subject.builder().name("programming").grade(10).build();
        Student student = Student.builder().name("rodrigomoraes").subjects(List.of(mathematics, portuguese, sciences, programming)).build();

        mockMvc.perform(post("/degree/analyzeNotes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(student)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.average", is(9.75)))
                .andExpect(jsonPath("$.message", is(CONGRATULATIONS_MESSAGE)));
    }

    @Test
    void whenCallingPostWithNamelessStudentItShouldThrowException() throws Exception {
        Subject mathematics = Subject.builder().name("mathematics").grade(5).build();
        Student student = Student.builder().subjects(List.of(mathematics)).build();

        mockMvc.perform(post("/degree/analyzeNotes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(student)))
                .andExpect(status().isBadRequest());
    }
}