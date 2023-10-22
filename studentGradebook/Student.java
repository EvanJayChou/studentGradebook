package studentGradebook;

import java.util.ArrayList;

public class Student {
	String name;
	int id;
	ArrayList<Grade> grades;
	
	public Student(String initName, int initId) {
		name = initName;
		id = initId;
		grades = new ArrayList<Grade>();
	}
	
	public String returnName() {
		return name;
	}
	
	public int returnID() {
		return id;
	}
	
	public void addNewGrade(Grade newGrade) {
		grades.add(newGrade);
	}
	
	public ArrayList<Grade> returnGradeList() {
		return grades;
	}
	
	public double calcGPA() {
		int sum = 0;
		for(int x = 0; x < grades.size(); x++) {
			String letter = grades.get(x).returnLetter();
			if(letter.equals("A")) 
				sum += 4;
			else if(letter.equals("B")) {
				sum += 3;
			}
			else if(letter.equals("C")) {
				sum += 2;
			}
			else if(letter.equals("D")) {
				sum += 1;
			}
			if(grades.get(x).returnHonor() == true)
				sum+=1;
		}
		return sum / grades.size();
	}
}
