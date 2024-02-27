package ru.kashtanov.myAppSpring.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**All logic of the project must be HERE*/
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public  StudentService (StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public List<Student> getStudents(){ // getting JSON
        return studentRepository.findAll();
//        return List.of(new Student("Viktor",
//                "p@mail.com",
//                LocalDate.of(1995, Month.DECEMBER,21),
//                28));
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional=(studentRepository.findStudentByEmail(student.getEmail()));
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email is taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
       boolean studentIsExists = studentRepository.existsById(studentId);
       if(!studentIsExists){
           throw new IllegalStateException("does not exist student with id = "+studentId);
       }
       studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalStateException("student with id = "+ studentId+ "does not exist"));
        if(name != null &&
           name.length()>0 &&
           !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email != null &&
                email.length()>0 &&
                !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
