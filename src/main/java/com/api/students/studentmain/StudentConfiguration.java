package com.api.students.studentmain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentConfiguration(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args -> {
            StudentModel ishan=new StudentModel(
                                    1,
                                    "Ishan",
                                    "ishan@gmail.com",
                                    LocalDate.of(1998, Month.SEPTEMBER,30)
            );
            StudentModel gelhi=new StudentModel(
                                    1,
                                    "gelhi",
                                    "gelhi@gmail.com",
                                    LocalDate.of(2000, Month.JANUARY,20)
            );
        repository.saveAll(List.of(ishan,gelhi));
        };

    }
}
