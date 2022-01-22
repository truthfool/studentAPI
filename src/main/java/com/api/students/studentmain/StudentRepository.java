package com.api.students.studentmain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Integer> {

//    @Query("select * from student_model where email=?1")
    Optional<StudentModel>findStudentByEmail(String email);
}
