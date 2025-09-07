import java.util.Scanner;

class Student {
    private String name;
    private String studentID;
    private int[] grades;

    // Constructor
    public Student(String name, String studentID, int[] grades) {
        this.name = name;
        this.studentID = studentID;
        this.grades = grades;
    }

    // Method to calculate average grade
    public double calculateAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    // Method to display individual grades
    public void displayGrades() {
        System.out.print("Grades: ");
        for (int grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
    }

    // Method to check pass/fail (assuming pass mark = 40)
    public boolean hasPassed() {
        return calculateAverage() >= 40;
    }

    // Method to display student details
    public void displayStudentInfo() {
        System.out.println("\nStudent Name: " + name);
        System.out.println("Student ID: " + studentID);
        displayGrades();
        System.out.println("Average: " + calculateAverage());
        System.out.println("Result: " + (hasPassed() ? "Passed" : "Failed"));
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine(); // consume newline

        Student[] students = new Student[numStudents];
        double totalClassAverage = 0;

        // Input multiple students
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Student ID: ");
            String id = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int numSubjects = sc.nextInt();

            int[] grades = new int[numSubjects];
            for (int j = 0; j < numSubjects; j++) {
                int grade;
                while (true) {
                    System.out.print("Enter grade for subject " + (j + 1) + " (0-100): ");
                    grade = sc.nextInt();
                    if (grade >= 0 && grade <= 100) {
                        grades[j] = grade;
                        break;
                    } else {
                        System.out.println("❌ Invalid input! Grade must be between 0 and 100.");
                    }
                }
            }
            sc.nextLine(); // consume newline

            students[i] = new Student(name, id, grades);
        }

        // Display details and calculate class average
        System.out.println("\n------ Student Results ------");
        for (Student s : students) {
            s.displayStudentInfo();
            totalClassAverage += s.calculateAverage();
        }

        double classAverage = totalClassAverage / numStudents;
        System.out.println("\nClass Average: " + classAverage);
    }
}
