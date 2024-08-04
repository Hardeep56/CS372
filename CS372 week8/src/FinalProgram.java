import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;

class Student implements Comparable<Student> {
    private String name;
    private String address;
    private double GPA;

    // Constructor
    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return GPA;
    }

    // toString method for formatted output
    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", GPA: " + GPA;
    }

    // Comparable implementation for sorting by name
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}

public class FinalProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Student> studentList = new LinkedList<>();
        String continueInput;

        // Loop to get student data from the user
        do {
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student's address: ");
            String address = scanner.nextLine();

            double GPA = 0;
            boolean validGPA = false;
            // Validate GPA input
            while (!validGPA) {
                try {
                    System.out.print("Enter student's GPA: ");
                    GPA = Double.parseDouble(scanner.nextLine());
                    if (GPA >= 0 && GPA <= 4.0) {
                        validGPA = true;
                    } else {
                        System.out.println("GPA must be between 0 and 4.0. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid GPA. Please enter a numeric value.");
                }
            }

            // Create a new student and add to the list
            studentList.add(new Student(name, address, GPA));

            System.out.print("Do you want to enter another student? (yes/no): ");
            continueInput = scanner.nextLine().toLowerCase();

        } while (continueInput.equals("yes"));

        // Sort the list by student name
        Collections.sort(studentList);

        // Write the sorted list to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("student_data.txt"))) {
            for (Student student : studentList) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Student data has been written to student_data.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
