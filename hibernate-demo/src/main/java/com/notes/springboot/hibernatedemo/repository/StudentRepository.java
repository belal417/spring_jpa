package com.notes.springboot.hibernatedemo.repository;

import com.notes.springboot.hibernatedemo.Entity.Passport;
import com.notes.springboot.hibernatedemo.Entity.Student;
import jakarta.persistence.EntityManager;
import org.hibernate.Internal;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager entityManager;
    public void addStudent() {
        Student student = entityManager.find(Student.class,30001);
        student.getId();
        student.getPassport();
    }
}
