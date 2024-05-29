package com.learnspringdata.sping_data_jpa.repository;

import com.learnspringdata.sping_data_jpa.entity.Course;
import com.learnspringdata.sping_data_jpa.entity.CourseMaterial;
import com.learnspringdata.sping_data_jpa.entity.Student;
import com.learnspringdata.sping_data_jpa.entity.Teacher;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseMaterialRepositoryTest {


  @Autowired
  CourseMaterialRepository courseMaterialRepository;

  @Test
  public void SaveCourseMaterial() {

    Course course = Course.builder()
        .credit(6)
        .title("JAVA")
        .build();

    CourseMaterial courseMaterial = CourseMaterial.builder()
        .url("www.javaconceptoftheday.com")
        .course(course)
        .build();

    courseMaterialRepository.save(courseMaterial);

  }

  @Test
  public void printAllCourseMaterial() {

    List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
    System.out.println("CourseMaterial: " + courseMaterials);
  }


}