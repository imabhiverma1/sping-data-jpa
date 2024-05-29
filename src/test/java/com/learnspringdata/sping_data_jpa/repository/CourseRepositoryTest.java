package com.learnspringdata.sping_data_jpa.repository;

import com.learnspringdata.sping_data_jpa.entity.Course;
import com.learnspringdata.sping_data_jpa.entity.Student;
import com.learnspringdata.sping_data_jpa.entity.Teacher;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CourseRepositoryTest {


  @Autowired
  private CourseRepository courseRepository;

  @Test
  public void saveCourseWithTeacher() {
    Teacher teacher = Teacher.builder()
        .firstName("abhishek")
        .lastName("singh")
        .build();

    Course course = Course.builder()
        .title("JAVA")
        .credit(9)
        .teacher(teacher)
        .build();

    courseRepository.save(course);
  }


  @Test
  public void saveCourseWithStudentAndTeacher() {
    Teacher teacher = Teacher.builder()
        .firstName("suresh")
        .lastName("verma")
        .build();

    Student student = Student.builder()
        .firstName("surya bhan")
        .lastName("singh")
        .emailId("xyz@gmail.com")
        .build();

    Course course = Course.builder()
        .title("AI")
        .credit(10)
        .teacher(teacher)
        .students(List.of(student))
        .build();
    courseRepository.save(course);
  }
}