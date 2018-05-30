package iti.t3ala2ma2olk.webservice.test1.main.java.com.questionmarks.persistence;

import iti.t3ala2ma2olk.webservice.test1.main.java.com.questionmarks.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
