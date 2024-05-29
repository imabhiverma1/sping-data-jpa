package com.learnspringdata.sping_data_jpa.repository;

import com.learnspringdata.sping_data_jpa.entity.Student;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  public List<Student> findByFirstName(String firstName);

  public List<Student> findByFirstNameContaining(String start);

  @Query("select s.firstName from Student as s where s.emailId = ?1")
  public String getStudentFirstNameByEmailAddress(String emailId);


  @Query(
      value = "select * from tbl_student s where s.email_address=?1",
      nativeQuery = true
  )
  Student getStudentByEmailAddressNative(String emailId);

  @Query(
      value = "select * from tbl_student s where s.email_address=:emailId",
      nativeQuery = true
  )
  Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);


  @Modifying
  @Transactional
  @Query(
      value = "update tbl_student set first_name=:firstName where email_address=:emailId",
      nativeQuery = true
  )
  public int updateStudentNameByEmailId(@Param(value = "firstName") String firstName,
      @Param(value = "emailId") String emailId);

}
