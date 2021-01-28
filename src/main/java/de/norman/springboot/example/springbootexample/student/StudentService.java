package de.norman.springboot.example.springbootexample.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = repository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email already taken");
        }

        repository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = repository.existsById(id);

        if (!exists) {
            throw new IllegalStateException("student with id " + id + " does not exist");
        }

        repository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("student with id " + id + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = repository.findStudentByEmail(student.getEmail());

            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email already taken");
            }
            student.setEmail(email);
        }
    }
}
