package com.learnspringdata.sping_data_jpa.repository;

import com.learnspringdata.sping_data_jpa.entity.Guardian;
import com.learnspringdata.sping_data_jpa.entity.Student;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

  @Autowired
  private StudentRepository studentRepository;

  @Test
  public void saveStudent() {
    Student student = Student.builder()
        .emailId("abhishek@gmail.com")
        .firstName("abhishek")
        .lastName("verma")
        //.guardianName("mohan lal verma").guardianMobile("99999999999")
        //  .guardianEmail("xyz@gmail.com")
        .build();

    studentRepository.save(student);
  }

  @Test
  public void saveStudentWIthGurdian() {

    Student student = Student.builder()
        .emailId("shiva@gmail.com")
        .firstName("shiva")
        .lastName("verma")
        .guardian(
            Guardian.builder()
                .name("hari")
                .email("hari@gmail.com")
                .mobile("978998989898")
                .build())
        .build();

    studentRepository.save(student);
  }

  @Test
  public void printAllStudent() {
    List<Student> studentList = studentRepository.findAll();

    System.out.println("Student List: " + studentList.toString());
  }


  @Test
  public void printStudentByFirstName() {
    List<Student> studentList = studentRepository.findByFirstName("abhishek");

    System.out.println(studentList);
  }


  @Test
  public void printStudentByFirstNameContaining() {
    List<Student> studentList = studentRepository.findByFirstNameContaining("ab");

    System.out.println(studentList);
  }

  @Test
  public void printGetStudentFirstNameByEmailAddress() {
    String firstName = studentRepository.getStudentFirstNameByEmailAddress("abhishek@gmail.com");
    System.out.println("First Name : " + firstName);
  }

  @Test
  public void printGetStudentByEmailAddressNative() {
    Student student = studentRepository.getStudentByEmailAddressNative("abhishek@gmail.com");
    System.out.println("Student = " + student);
  }

  @Test
  public void printGetStudentByEmailAddressNativeNamed() {
    Student student = studentRepository.getStudentByEmailAddressNativeNamedParam(
        "abhishek@gmail.com");
    System.out.println("Student = " + student);
  }

  @Test
  public void updateStudentNameByEmailId() {
    studentRepository.updateStudentNameByEmailId(
        "aditya",
        "abhishek@gmail.com");
  }
}