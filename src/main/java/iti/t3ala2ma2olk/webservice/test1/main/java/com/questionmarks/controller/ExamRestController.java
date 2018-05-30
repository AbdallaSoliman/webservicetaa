package iti.t3ala2ma2olk.webservice.test1.main.java.com.questionmarks.controller;

import iti.t3ala2ma2olk.webservice.test1.main.java.com.questionmarks.model.Exam;
import iti.t3ala2ma2olk.webservice.test1.main.java.com.questionmarks.model.dto.ExamCreationDTO;
import iti.t3ala2ma2olk.webservice.test1.main.java.com.questionmarks.model.dto.ExamUpdateDTO;
import iti.t3ala2ma2olk.webservice.test1.main.java.com.questionmarks.persistence.ExamRepository;
import iti.t3ala2ma2olk.webservice.dto.profile.util.DTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamRestController {
    private ExamRepository examRepository;

    public ExamRestController(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @GetMapping
    public List<Exam> getExams() {
        return examRepository.findAll();
    }

    @PostMapping
    public void newExam(@DTO(ExamCreationDTO.class) Exam exam) {
        examRepository.save(exam);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editExam(@DTO(ExamUpdateDTO.class) Exam exam) {
        examRepository.save(exam);
    }
}