package za.ac.cput.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.repository.student.IStudentAddressRepository;

import java.util.List;
import java.util.Optional;
@Service
public class StudentAddressService implements IStudentAddressService {
    private final IStudentAddressRepository repository;

    @Autowired
    public StudentAddressService(IStudentAddressRepository repository){
        this.repository = repository;
    }

    @Override
    public StudentAddress save(StudentAddress studentAddress) {
        return this.repository.save(studentAddress);
    }

    @Override
    public Optional<StudentAddress> read(String studentId) {
        return this.repository.findById(studentId);
    }

    @Override
    public void delete(StudentAddress studentAddress) {
        this.repository.delete(studentAddress);

    }

    @Override
    public List<StudentAddress> findAll() {
        return this.repository.findAll();
    }
}
