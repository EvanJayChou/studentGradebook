package studentGradebook;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
	private Map<Integer, Student> userData;
	
	public UserDatabase() {
		userData = new HashMap<>();
	}
	
	public void addUser(String name, int id) {
		Student user = new Student(name, id);
		userData.put(id, user);
	}
	
	public Student getUserInformation(int id) {
		return userData.get(id);
	}
	
	public static void main(String[] args) {
		UserDatabase database = new UserDatabase();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("What would you like to do today?");
			System.out.println("1. Add student information");
			System.out.println("2. Access student information");
			System.out.println("3. Exit");
			int choice = scanner.nextInt();
			switch(choice) {
			
			case 1:
				System.out.print("Enter student name: ");
				String studentName = scanner.nextLine();
				System.out.print("Enter student ID");
				int studentID = scanner.nextInt();
				database.addUser(studentName, studentID);
				System.out.println("User information added successfully.");
				break;
				
			case 2:
				System.out.println("Enter student ID to retrieve information.");
				int input2 = scanner.nextInt();
				Student retrieval = database.getUserInformation(input2);
					if(retrieval != null) {
						// Program for when there is user-saved data
						System.out.println("Hello, " + retrieval.returnName() + "!");
						System.out.println("Check student details \t Display all grades \t Display stats");
						Scanner in = new Scanner(System.in);
						String input = in.nextLine();
						if(input.equals("Check student details")) {
							System.out.println("Name: " + retrieval.returnName() + "\t ID: " + retrieval.returnID());
						}
						if(input.equals("Display all grades")) {
							for(Grade x : retrieval.returnGradeList()) 
								System.out.println(x.returnSubject() + ": " + x.returnGrade());
						}
						if(input.equals("Display stats")) {
							Grade highest = retrieval.returnGradeList().get(0);
							for(Grade x : retrieval.returnGradeList()) {
								if(x.returnGrade() > highest.returnGrade())
									highest = x;
							}
							Grade lowest = retrieval.returnGradeList().get(0);
							for(Grade x : retrieval.returnGradeList()) {
								if(x.returnGrade() < highest.returnGrade())
									lowest = x;
							}
							System.out.println("Highest: " + highest.returnSubject() + " " + highest.returnGrade());
							System.out.println("Lowest: " + lowest.returnSubject() + " " + lowest.returnGrade());
							System.out.println("Total GPA: " + retrieval.calcGPA());
						}
					}
					else 
						System.out.println("Student not found.");
					
			case 3:
				System.out.println("Exiting. Goodbye!");
				System.exit(0);
				
			default:
				System.out.println("Invalid choice. Please enter a valid option");
			}
		}
	}
}