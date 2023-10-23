package com.notes.springboot.hibernatedemo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.UpdateTimestamp;

@ToString
@Data
@Entity
@NamedQueries({
        @NamedQuery(name = "get_all_coursces", query = "select c from Course c"),
        @NamedQuery(name = "get_query_by_name",query = "select c from Course c where c.name like '%Physics%'")
})
public class Course {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "course_name")
    private String name;

    @CreationTimestamp
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    private LocalDateTime updatedDateTime;

    public Course( String name) {
        this.name = name;
    }

    protected Course(){}  //mandated by JPA
}
