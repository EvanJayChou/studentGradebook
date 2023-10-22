package studentGradebook;

import java.util.ArrayList;

public class Grade {
	String subject;
	double totalGrade;
	String letterGrade;
	ArrayList<Double> grades;
	boolean honor;
	
	public Grade(String subName) {
		subject = subName;
		grades = new ArrayList<Double>();
		for(int x = 0; x < subject.length() - 1; x++) {
			if(subject.substring(x, x+2).equals("AP") || subject.substring(x, x+2).equals("Honors"))
				honor = true;
		}
	}
	
	public void addGrade(double newGrade) {
		grades.add(newGrade);
		int sum = 0;
		for(int x = 0; x < grades.size(); x++) {
			sum += grades.get(x);
		}
		totalGrade = sum / grades.size();
	}

	public double returnGrade() {
		return totalGrade;
	}
	
	public String returnLetter() {
		if(totalGrade >= 90) 
			return "A";
		else if(totalGrade >= 80) 
			return "B";
		else if(totalGrade >= 70)
			return "C";
		else if(totalGrade >= 60)
			return "D";
		else
			return "F";
	}
	
	public String returnSubject() {
		return subject;
	}
	
	public boolean returnHonor() {
		return honor;
	}
}
