package com.notes.springboot.hibernatedemo;

import com.notes.springboot.hibernatedemo.Entity.Course;
import com.notes.springboot.hibernatedemo.repository.CourseRepository;
import com.notes.springboot.hibernatedemo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateDemoApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
/*		Course course = courseRepository.findById(10001L);
		logger.info("Course details {}",course);

		courseRepository.deleteById(10001L);
		Course c1 = new Course("BiologyCourse");
		courseRepository.saveCourse(c1);*/

		//courseRepository.CrudWithEntityManager();

		//courseRepository.jpql();

		//courseRepository.workingWithEntityAnnotation();

		//courseRepository.checkNamedQuery();
		courseRepository.m1();
		studentRepository.addStudent();

	}
}
