package com.keerthi.studentapp.service;

import com.keerthi.studentapp.entity.Student;
import com.keerthi.studentapp.entity.Subject;
import com.keerthi.studentapp.exception.StudentNotFoundException;
import com.keerthi.studentapp.repository.StudentRepository;
import com.keerthi.studentapp.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Add a new subject
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    // Get all subjects
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    // Assign subject to student
    public Student assignSubjectToStudent(Long studentId, Long subjectId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + subjectId));

        student.getSubjects().add(subject);
        return studentRepository.save(student);
    }

    // Get all subjects of a student
    public List<Subject> getSubjectsOfStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
        return student.getSubjects().stream().toList();
    }
}