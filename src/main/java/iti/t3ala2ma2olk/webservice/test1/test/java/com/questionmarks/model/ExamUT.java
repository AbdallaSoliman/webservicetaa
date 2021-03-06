package iti.t3ala2ma2olk.webservice.test1.test.java.com.questionmarks.model;

import iti.t3ala2ma2olk.webservice.test1.main.java.com.questionmarks.model.Exam;
import iti.t3ala2ma2olk.webservice.test1.main.java.com.questionmarks.model.dto.ExamCreationDTO;
import iti.t3ala2ma2olk.webservice.test1.main.java.com.questionmarks.model.dto.ExamUpdateDTO;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import iti.t3ala2ma2olk.webservice.businesslayer.factory.ModelMapperFactory;

import static org.junit.Assert.assertEquals;

public class ExamUT {
       private static final ModelMapper modelMapper = ModelMapperFactory.getModelMapper();

    @Test
    public void checkExamMapping() {
        ExamCreationDTO creation = new ExamCreationDTO();
        creation.setTitle("Testing title");
        creation.setDescription("Testing description");

        Exam exam = modelMapper.map(creation, Exam.class);
        assertEquals(creation.getTitle(), exam.getTitle());
        assertEquals(creation.getDescription(), exam.getDescription());
        assertEquals(creation.getCreatedAt(), exam.getCreatedAt());
        assertEquals(creation.getEditedAt(), exam.getEditedAt());

        ExamUpdateDTO update = new ExamUpdateDTO();
        update.setTitle("New title");
        update.setDescription("New description");

        modelMapper.map(update, exam);
        assertEquals(update.getTitle(), exam.getTitle());
        assertEquals(update.getDescription(), exam.getDescription());
        assertEquals(creation.getCreatedAt(), exam.getCreatedAt());
        assertEquals(update.getEditedAt(), exam.getEditedAt());
    }
}
