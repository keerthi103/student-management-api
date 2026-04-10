package com.keerthi.studentapp.controller;

import com.keerthi.studentapp.entity.Student;
import com.keerthi.studentapp.entity.Subject;
import com.keerthi.studentapp.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    // Add a new subject
    @PostMapping
    public Subject addSubject(@RequestBody Subject subject) {
        return subjectService.addSubject(subject);
    }

    // Get all subjects
    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    // Assign subject to student
    @PostMapping("/assign/{studentId}/{subjectId}")
    public Student assignSubject(@PathVariable Long studentId,
                                 @PathVariable Long subjectId) {
        return subjectService.assignSubjectToStudent(studentId, subjectId);
    }

    // Get all subjects of a student
    @GetMapping("/student/{studentId}")
    public List<Subject> getSubjectsOfStudent(@PathVariable Long studentId) {
        return subjectService.getSubjectsOfStudent(studentId);
    }
}