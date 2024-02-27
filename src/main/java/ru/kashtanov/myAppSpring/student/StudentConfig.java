package ru.kashtanov.myAppSpring.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
             Student student1 =new Student(
                     "Viktor",
                     "p@mail.com",
                      LocalDate.of(1995, Month.DECEMBER,21)
                     );
            Student student2 =new Student(
                    "Billy",
                    "b@mail.com",
                    LocalDate.of(1999, Month.DECEMBER,21)
                    );
            repository.saveAll(List.of(student1,student2));

        };
    }


}
