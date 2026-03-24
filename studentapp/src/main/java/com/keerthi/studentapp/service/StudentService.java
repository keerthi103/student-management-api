package com.keerthi.studentapp.service;

import com.keerthi.studentapp.entity.Student;
import com.keerthi.studentapp.exception.StudentNotFoundException;
import com.keerthi.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existing = studentRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedStudent.getName());
            existing.setEmail(updatedStudent.getEmail());
            existing.setDepartment(updatedStudent.getDepartment());
            return studentRepository.save(existing);
        }
        return null;
    }
}