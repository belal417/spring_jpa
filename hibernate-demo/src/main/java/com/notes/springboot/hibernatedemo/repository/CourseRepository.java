package com.notes.springboot.hibernatedemo.repository;

import com.notes.springboot.hibernatedemo.Entity.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class,id);
    }

    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course);
    }

    public Course saveCourse(Course course){
        if (course.getId()==null){
            em.persist(course);
        }else{
            em.merge(course);
        }
        return course;
    }


    public void CrudWithEntityManager(){
        Course c1 = new Course("Physics");
        Course c2 = new Course("Chemistry");

        em.persist(c1);
        em.persist(c2);

        c1.setName("Physics Updated"); // it will still persist,even after em.persist is called already

        em.flush();
        c1.setName("Physics Flushed"); // it will not update since we have used em.flush

        em.refresh(c1); //It will bring back the data form database
        c2.setName("Chemistry refreshed");
        em.refresh(c2);

    }

    public void jpql(){
       List list =em.createQuery("select c from Course c").getResultList();
        System.out.println("List value -->"+list); //List value -->[Course(id=1, name=BiologyCourse), Course(id=10002, name=PhysicsCourse), Course(id=10003, name=ChemistryCourse)]

        TypedQuery<Course> tq = em.createQuery("select c from Course c where c.name like '%Physics%'",Course.class);
        List<Course> listtq = tq.getResultList();
        System.out.println(" List with Course -->"+listtq); // List with Course -->[Course(id=10002, name=PhysicsCourse)]

        List<Course> listWithParam =em.createQuery("select c from Course c where name = :name",Course.class)
                .setParameter("name","PhysicsCourse")
                .getResultList();
        System.out.println(" List with Course -->"+listWithParam); // List with Course -->[Course(id=10002, name=PhysicsCourse)]



    }

    public void workingWithEntityAnnotation() {
        Course newBookCourse = new Course("New Book Course");
        em.persist(newBookCourse);
        newBookCourse.setName("New Book Course Updated");
        Course newBookCourse2 = new Course("New Book Course 2");
        em.persist(newBookCourse2);


    }

    public void checkNamedQuery() {

        checkNameQuery1();
        checkNameQuery2();
        checkNameQuery3();
        m1();

    }
    public static void m1(){
        System.out.println("Running Static Method....");
    }
    public void checkNameQuery1(){
        List<Course> list = em.createNamedQuery("get_all_coursces").getResultList();
        System.out.println("List 1 CheckNameQuery :: "+list);
    }
    public void checkNameQuery2(){
        List<Course> list = em.createNamedQuery("get_all_coursces").getResultList();
        System.out.println("List 2 CheckNameQuery :: "+list);
    }

    public void checkNameQuery3(){
        List<Course> list = em.createNamedQuery("get_query_by_name").getResultList();
        System.out.println("List 3 CheckNameQuery :: "+list);
    }
}
