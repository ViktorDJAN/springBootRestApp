package ru.kashtanov.myAppSpring.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",// name for which Entity it is assigned for .in our case for Student
            sequenceName = "student_sequence", // name of the sequence
            allocationSize = 1 // step of allocation id= 1 ,id=2,id=3...
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    /** The @Transient annotation in JPA is used to indicate fields in classes that should not be stored in the database.*/
    /** This ensures that such fields do not affect the database schema or table.
         Examples of using:
       1. Fields that can be calculated or derived from other persistent fields.
       2. Fields that can temporarily store data while the application is running and do not need to be stored in the database.
       3. Fields used for intermediate processing or temporary storage in application logic.*/
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob
                 ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Student(String name,
                   String email,
                   LocalDate dob
               ) {
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Strudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
