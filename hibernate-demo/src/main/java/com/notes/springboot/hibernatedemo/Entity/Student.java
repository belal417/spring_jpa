package com.notes.springboot.hibernatedemo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue
    Long id;

    String name;

    @OneToOne (fetch = FetchType.LAZY)
    private Passport passport;


}
