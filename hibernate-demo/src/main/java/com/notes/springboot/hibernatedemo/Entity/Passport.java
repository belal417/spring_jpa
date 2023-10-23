package com.notes.springboot.hibernatedemo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Passport {

    @Id
            @GeneratedValue
    Long id;

    String number;

    @OneToOne(mappedBy = "passport")
    private Student student;

    public Passport(String number) {
        this.number = number;
    }






}
