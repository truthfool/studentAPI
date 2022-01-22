package com.api.students.studentmain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentModel> getStudents()
    {
        return studentRepository.findAll();
    }
    public void addStudents(StudentModel students)
    {
        Optional<StudentModel> studentoptional= studentRepository.findStudentByEmail(students.getEmail());
        if(studentoptional.isPresent())
        {
            throw new IllegalStateException("Student already exists");
        }
        studentRepository.save(students);
    }
    public void deleteStudent(int studentId)
    {
        boolean exists=studentRepository.existsById(studentId);
        if(!exists)
        {
            throw new IllegalStateException("Student by id"+studentId+"does not exists");
        }
        studentRepository.deleteById(studentId);
    }
    public void updateStudent(int studentId,String email,String name)
    {

    }
}
