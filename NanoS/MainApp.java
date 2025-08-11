/*
    Compile the code: javac MainApp.java

          "OR"
    Compile the code: javac *.java
   
   Run the code: java MainApp
 */

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. Array Operations");
            System.out.println("2. Linked List Operations");
            System.out.println("3. Stack Operations");
            System.out.println("4. Queue Operations");
            System.out.println("5. Tree Operations");
            System.out.println("6. String Operations");
            System.out.println("7. Virtual File System");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    Array.main(new String[]{}); break;
                case 2:
                    GenericLinkedListApp.main(new String[]{}); break;
                 case 3:
                      GenericStack.main(new String[]{}); break;
                case 4:
                     GeneriQueue.main(new String[]{}); break;
                case 5:
                    GenericTree.main(new String[]{}); break;
                case 6:
                    StringOperationsApp.main(new String[]{}); break;
                case 7:
                    VirtualFileSystem.main(new String[]{}); break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
