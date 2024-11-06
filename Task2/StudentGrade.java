// 

import java.util.Scanner;

class StudentGrade {
    public static void main(String[] args) {
        System.out.print("Enter The Number Of Subjects: ");
        
        // Input from user
        Scanner sc = new Scanner(System.in);
        int subjects = sc.nextInt(); // Number of subjects
        int total = 0;
        char grade;
        double average;
        int[] marks = new int[subjects];
        
        // Entering the marks of each subject
        System.out.println("Caution! Marks Should Be In Between 0-100 (Inclusive).");
        System.out.println("Enter The Marks Of Each Subject.");
        
        for (int i = 0; i < subjects; i++) {
            while (true) {
                System.out.print("Subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
                
                // Check if the marks are within the valid range
                if (marks[i] < 0 || marks[i] > 100) {
                    System.out.println("Warning! Enter marks between 0 and 100 (Inclusive).");
                } else {
                    break; // Exit the loop if marks are valid
                }
            }
        }
        
        // Calculating the sum of marks
        for (int sum : marks) {
            total += sum;
        }
        
        // Calculating the average percentage
        average = total / (double) subjects; // Cast to double for accurate division
        
        // Grade calculation
        if (average >= 85) {
            grade = 'A';
        } else if (average >= 70) {
            grade = 'B';
        } else if (average >= 55) {
            grade = 'C';
        } else if (average >= 36) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        // Check if any subject is failed
        boolean hasFailed = false;
        for (int mark : marks) {
            if (mark < 36) {
                hasFailed = true;
                break;
            }
        }
        
        // Output results based on marks
        if (hasFailed) {
            System.out.println("Sorry! You Have Failed In This Semester.");
            System.out.println("Kindly Prepare Well For Upcoming Semester.");
        } else {
            System.out.println("Total Marks In This Semester: " + total);
            System.out.printf("Your Percentage is: %.2f%%%n", average);
            System.out.println("Congratulations! You Have Passed This Semester With Grade: " + grade);
        }
        
        sc.close();
    }
}
