/*
 * Author: Darcy Zeng
 */

import java.util.*;

public class CourseGradeCalculator extends ValidInput{

    //List of String that save the list of grade item
    List<String> gradingList;
    //double array that stores the weight of grade item
    double[] fraction;
    //double array that stores the percentage of grade achieved
    double[] grade;
    //boolean that shows if the imput is valid.
    boolean validInput = true;
    
    //function that asks the user to enter input
    public void input(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter grade items");
        System.out.println("Enter \"end\" to end input");
        String input = scan.nextLine();
        this.gradingList = new ArrayList<>();
        
        //Ask the user to enter the grading items until the user enters "end".
        while(!input.equals("end")){
            this.gradingList.add(input);
            input = scan.nextLine();
        }

        this.fraction = new double[gradingList.size()];
        double inputGrade;
        System.out.println("Enter the weight of each gradinf factores in percentage (Example:Exam is 50% of overall, therefore enter 50)");
        
        //Ask the user to input the weight of each gradeing item in percent.
        for(int i=0;i<gradingList.size();i++){
            System.out.println("weight for " + gradingList.get(i) + ":");
            input = scan.nextLine();
            validInput = checkValidility(input);
            while(!validInput){
                input = scan.nextLine();
                validInput = checkValidility(input);
            }
            inputGrade = Double.valueOf(input);
            fraction[i] = inputGrade;
        }

        this.grade = new double[fraction.length];
        double receivedGrade;
        System.out.println("Enter the grade you received in percentage.");

        //Ask the user to enter the achived grade in percentage.
        for(int i=0;i<gradingList.size();i++){
            System.out.println("grade for " + gradingList.get(i) + ":");
            input = scan.nextLine();
            validInput = checkValidility(input);
            while(!validInput){
                input = scan.nextLine();
                validInput = checkValidility(input);
            }
            receivedGrade = Double.valueOf(input);
            grade[i] = receivedGrade;

        }
        scan.close();
        //print the final grade.
        System.out.print("Your final grade is : " + calculate() + "%");
    }

    //calculate the final grade by adding achived grade / weight percentage in decimals to the final grade.
    public double calculate(){
        double finalGrade = 0.0;
        for(int i=0;i<grade.length;i++){
            finalGrade += (grade[i]*(fraction[i]/100.0));
        }
        return finalGrade;
    }

    public static void main(String args[]){
        CourseGradeCalculator calculator = new CourseGradeCalculator();
        calculator.input();

    }
    
}