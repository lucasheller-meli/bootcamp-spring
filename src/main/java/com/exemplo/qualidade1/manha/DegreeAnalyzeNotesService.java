package com.exemplo.qualidade1.manha;

import org.springframework.stereotype.Service;

@Service
public class DegreeAnalyzeNotesService {
    private static final String FAILED_MESSAGE = "Unfortunately you have failed this semester.";
    private static final String CONGRATULATIONS_MESSAGE = "Congratulations, you have learned everything that this semester had to offer!";
    private static final String APPROVED_MESSAGE = "You have been approved.";

    public Degree generateDegree(Student student) {
        Double averageGrade = averageGrade(student);

        return Degree.builder()
                .student(student)
                .average(averageGrade)
                .message(message(averageGrade))
                .build();
    }

    private Double averageGrade(Student student) {
        return student.getSubjects().stream().mapToDouble(Subject::getGrade).average().orElse(0);
    }

    private String message(Double grade) {
        if (grade < 6) return FAILED_MESSAGE;

        if (grade > 9) return CONGRATULATIONS_MESSAGE;

        return APPROVED_MESSAGE;
    }
}
