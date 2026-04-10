package com.keerthi.studentapp.entity;

import com.keerthi.studentapp.enums.SubjectType;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private SubjectType type;

    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students = new HashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id;}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public SubjectType getType() { return type; }
    public void setType(SubjectType type) { this.type = type; }
}