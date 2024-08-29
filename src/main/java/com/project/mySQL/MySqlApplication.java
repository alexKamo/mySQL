package com.project.mySQL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySqlApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) { return runner -> {
//		createStudent(studentDAO);};
//		readStudent(studentDAO);
//		queryForStudents(studentDAO);
//		queryByLastName(studentDAO);
		queryEmail(studentDAO);
	};

	}

	private void createStudent(StudentDAO studentDAO) {
	// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Alex", "Kamo", "alex@.com");
	// save the student object
		System.out.println("Saving the student..."); studentDAO.save(tempStudent);
	// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId()); }

	private void readStudent(StudentDAO studentDAO) {
//	// create a student object
//		System.out.println("Creating new student object...");
//		Student tempStudent = new Student("Daffy", "Duck", "daffy@.com");
//	// save the student object
//		System.out.println("Saving the student..."); studentDAO.save(tempStudent);
//	// display id of the saved student
//		System.out.println("Saved student. Generated id: " + tempStudent.getId()); // retrieve student based on the id: primary key
//		System.out.println("\nRetrieving student with id: " + tempStudent.getId());
		Student myStudent = studentDAO.findById(2);
		System.out.println("Found the student: " + myStudent);
	}

	private void queryByLastName(StudentDAO studentDAO){
		List<Student> students = studentDAO.findByLastName("kamo");
		System.out.println(students);
	}

	private void queryEmail(StudentDAO studentDAO){
		List<Student> students = studentDAO.findByEmail("com");
		System.out.println(students);
	}

	private void queryForStudents(StudentDAO studentDAO) {
	// get list of students
		List<Student> theStudents = studentDAO.findAll();
	// display list of students
		for (Student tempStudent : theStudents) { System.out.println(tempStudent);}
	}

}
