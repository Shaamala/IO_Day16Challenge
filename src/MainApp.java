import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = null;
        int age = 0;
        String food = null;

        // create list to hold employees information
        ArrayList <Employee> employeeslist = new ArrayList <>();
        String directoryString = "resources";// directory assigned name

        System.out.println(" Do you want to add your Information: (y/n)");
        String answer = scan.nextLine();
        // loop for enter multiple employees
        while (answer.equalsIgnoreCase("y")) {
            System.out.println("Please enter emplyee name :");
            name = scan.next();
            System.out.println("please enter employee age: ");
            age = scan.nextInt();
            System.out.println("Please enter employee favorite food: ");
            food = scan.next();
            // create new object
            Employee emp = new Employee(name, age, food);
            // add the object to employee list
            employeeslist.add(emp);
            System.out.println(" Do yoy want add more? (y/n)");
            answer = scan.next();
        }
        //  call create directory method
        createDirectory(directoryString);
        //  call create file method
        createFile(directoryString, "Employee.txt");
        //  call write method
        writeToFile(directoryString, "Employee.txt", employeeslist);

    }
    // create directory method
    public static void createDirectory(String dirString) {
        Path dirPath = Paths.get(dirString);

        if (Files.notExists(dirPath)) {

            try {
                Files.createDirectory(dirPath);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("I'm not sure what happened, contact customer service");
            }
        }

    }
    // create file method
    public static void createFile(String dirString, String fileString) {

        //get method I can choice from two or one parameter
        Path filePath = Paths.get(dirString, fileString);
        if (Files.notExists(filePath)) {
            try {
                Files.createFile(filePath);
                System.out.println(" Your file created successfully");
            } catch (IOException e) {
                System.out.println("Hey something went wrong with the file creation!");
                ;
            }
        }

    }
    // create writing in file method
    public static void writeToFile(String dirString, String fileString, ArrayList <Employee> emplopyeeList) {
        Path writeFile = Paths.get(dirString, fileString);

        File file = writeFile.toFile();

        try {

            PrintWriter printOut = new PrintWriter(new FileOutputStream(file, true));
            for (Employee emp : emplopyeeList) {
                printOut.println(emp);
            }
            printOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
