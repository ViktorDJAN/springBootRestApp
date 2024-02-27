package ru.kashtanov.myAppSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kashtanov.myAppSpring.student.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@SpringBootApplication
public class MyAppSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppSpringApplication.class, args);

	}


}
