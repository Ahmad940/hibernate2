import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import models.Students;

public class StudentManagement {
	Scanner scanner = new Scanner(System.in);
	
	public void startApp(Session session) {
		while (true) {
			System.out.println("1) Print all students");
			System.out.println("2) Print a student");
			System.out.println("3) Add a student");
			System.out.println("5) Update a students");
			System.out.println("6) delete a students");
			System.out.println("7) delete all students");
			
			System.out.print("Select an option: ");
			int option = scanner.nextInt();
			
			switch(option) {
			case 1: 
				printAllStudents(session);
				break;
			case 2: 
			case 3: 
			}
		}
	}
	
	public void saveStudent(Session session) {
		System.out.print("Enter student full Name: ");
		String fName = scanner.nextLine();
		
		Students student = new Students();
		student.setFullName(fName);
		
		session.persist(student);
	}
	
	public void printAllStudents(Session session) {
		List<Students> studentsList = session.
				createQuery("SELECT a FROM Students a", 
						Students.class).getResultList();
		studentsList.forEach(s -> {
			System.out.println(s);
		});
	}
}
