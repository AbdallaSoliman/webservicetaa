package iti.t3ala2ma2olk.webservice.test1.main.java.com.questionmarks.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


//    @ManyToOne
//    @JoinColumn (name = "alternative_id")
//    private Alternative alternative;


    private Date date;

    private boolean correct;
}