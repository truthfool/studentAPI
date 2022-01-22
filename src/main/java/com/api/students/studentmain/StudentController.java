package com.api.students.studentmain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }

    @GetMapping
    public List<StudentModel> getStudents()
    {
        return studentService.getStudents();
    }

    @PostMapping
    public void addStudents(@RequestBody StudentModel students){
        studentService.addStudents(students);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId)
    {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = {"studentId"})
    public void updateStudent(@PathVariable("studentId") int studentId,
                                @RequestParam(required = false) String email,
                              @RequestParam(required = false) String name)
    {

        studentService.updateStudent(studentId,email,name);
    }
}
