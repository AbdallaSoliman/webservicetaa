package iti.t3ala2ma2olk.webservice.test1.main.java.com.questionmarks.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String title;


    private String description;


    private LocalDateTime createdAt;


    private LocalDateTime editedAt;


    private boolean published;
}