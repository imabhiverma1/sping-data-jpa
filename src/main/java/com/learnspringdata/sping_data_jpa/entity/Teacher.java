package com.learnspringdata.sping_data_jpa.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

  @Id
  @SequenceGenerator(name = "teacherId_sequence", sequenceName = "teacherId_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacherId_sequence")
  private Long teacherId;
  private String firstName;
  private String lastName;

  /*@OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
  private List<Course> courses;*/

}
