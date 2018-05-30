package iti.t3ala2ma2olk.webservice.test1.main.java.com.questionmarks.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    private String id;
}