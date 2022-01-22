package com.api.students.studentmain;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<StudentModel> getStudents()
    {
        return List.of(
                new StudentModel(1,
                "Ishan",
                "ishan@gmail.com",
                22,
                LocalDate.of(2000, Month.APRIL,20))
        );
    }
}
