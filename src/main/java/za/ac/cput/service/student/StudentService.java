package za.ac.cput.service.student;

/* StudentService.java
Service implementation for Student
Author: Cameron Henry Noemdo (219115443)
Date: 13 June 2022
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.student.Student;
import za.ac.cput.repository.student.IStudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    private final IStudentRepository repository;

    @Autowired private StudentService(IStudentRepository repository) {
        this.repository=repository;
    }
    @Override
    public Student save(Student student) {
        return this.repository.save(student);
    }

    @Override
    public Optional<Student> read(String studentId) {
        return this.repository.findById(studentId);
    }

    @Override
    public void delete(Student student) {
        this.repository.delete(student);
    }

    @Override
    public List<Student> findAll() {
        return this.repository.findAll();
    }

//    @Override
//    public List<Student> findStudentsByCountryId(String countryId) {
//        return null;
//    }
}
