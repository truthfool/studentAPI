package com.api.students.studentmain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class StudentModel {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private int id;
    private String name;
    private String email;
    @Transient
    private int age;
    private LocalDate dob;

    public StudentModel() {
    }

    public StudentModel(int id, String name, String email, LocalDate dob)
    {
        this.id=id;
        this.name=name;
        this.email=email;
//        this.age=age;
        this.dob=dob;
    }
    public StudentModel(String name,String email,int age,LocalDate dob)
    {
        this.name=name;
        this.email=email;
//        this.age=age;
        this.dob=dob;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {

        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
