package com.learnspringdata.sping_data_jpa.repository;

import com.learnspringdata.sping_data_jpa.entity.Course;
import com.learnspringdata.sping_data_jpa.entity.Teacher;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {

  @Autowired
  private TeacherRepository teacherRepository;

  @Test
  public void saveTeacher() {
    Course courseDSA = Course
        .builder()
        .title("DSA")
        .credit(5)
        .build();

    Course coursePython = Course
        .builder()
        .title("Python")
        .credit(8)
        .build();

    Teacher teacher = Teacher.builder()
        .firstName("ramesh")
        .lastName("sharma")
       // .courses(List.of(coursePython, courseDSA))
        .build();

    teacherRepository.save(teacher);
  }

}