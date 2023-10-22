package studentGradebook;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Test User Information
		Student test = new Student("Bob", 123);
		test.addNewGrade(new Grade("Math"));
		test.addNewGrade(new Grade("AP English"));
		test.addNewGrade(new Grade("Biology Honors"));
		for(Grade x : test.returnGradeList()) {
			for(int y = 0; y < 50; y++) {
				x.addGrade(Math.random() * 100);
			}
		}
		
		
		// Program for when there is user-saved data
		System.out.println("What would you like to do today?");
		System.out.println("Check student details \t Display all grades \t Display stats");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		if(input.equals("Check student details")) {
			System.out.println("Name: " + test.returnName() + "\t ID: " + test.returnID());
		}
		if(input.equals("Display all grades")) {
			for(Grade x : test.returnGradeList()) 
				System.out.println(x.returnSubject() + ": " + x.returnGrade());
		}
		if(input.equals("Display stats")) {
			Grade highest = test.returnGradeList().get(0);
			for(Grade x : test.returnGradeList()) {
				if(x.returnGrade() > highest.returnGrade())
					highest = x;
			}
			Grade lowest = test.returnGradeList().get(0);
			for(Grade x : test.returnGradeList()) {
				if(x.returnGrade() < highest.returnGrade())
					lowest = x;
			}
			System.out.println("Highest: " + highest.returnSubject() + " " + highest.returnGrade());
			System.out.println("Lowest: " + lowest.returnSubject() + " " + lowest.returnGrade());
			System.out.println("Total GPA: " + test.calcGPA());
		}
	}

}
