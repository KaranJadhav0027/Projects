
import java.util.*;

class StackNode<T> {
    public T data;
    public StackNode<T> next;

    public StackNode(T x) {
        data = x;
        next = null;
    }
}

class Stack<T> {
    public StackNode<T> head;
    public int iCount;

    public Stack() {
        head = null;
        iCount = 0;
    }

    // Push a value onto the stack
    public void Push(T no) {
        StackNode<T> newn = new StackNode<>(no);

        if (head == null) {
            head = newn;
        } else {
            newn.next = head;
            head = newn;
        }
        iCount++;
    }

    // Display the elements of the stack
    public void Display() {
        System.out.println("Elements of the Stack are:");
        StackNode<T> temp = head;

        while (temp != null) {
            System.out.println("###########################################");
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Return the number of elements in the stack
    public int Count() {
         System.out.println("###########################################");
        return iCount;
    }

    // Pop a value from the stack
    public T Pop() {
        if (head == null) {
            System.out.println("Stack is empty.");
            return null;
        }

        T no = head.data;
        head = head.next;
        iCount--;
        return no;
    }
}

public class GenericStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Choose the type of stack (Integer or String)
        System.out.println("Enter the type of stack you want to use (1 - Integer, 2 - String): ");
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice == 1) {
            Stack<Integer> intStack = new Stack<>();
            operateIntegerStack(scanner, intStack);
        } else if (choice == 2) {
            Stack<String> stringStack = new Stack<>();
            operateStringStack(scanner, stringStack);
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    // Method to operate on Integer stack
    public static void operateIntegerStack(Scanner scanner, Stack<Integer> stack) {
        int choice;
        while (true) {
            System.out.println("\nStack Operations Menu (Integer Stack):");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display Stack");
            System.out.println("4. Count Elements in Stack");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // Push
                    System.out.print("Enter the value to push onto the stack: ");
                    int value = scanner.nextInt();
                    stack.Push(value);
                    System.out.println("Pushed " + value);
                    break;

                case 2: // Pop
                    Integer result = stack.Pop();
                    if (result != null) {
                        System.out.println("Popped: " + result);
                    }
                    break;

                case 3: // Display Stack
                    stack.Display();
                    break;

                case 4: // Count Elements
                    System.out.println("Number of elements in the stack: " + stack.Count());
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to operate on String stack
    public static void operateStringStack(Scanner scanner, Stack<String> stack) {
        int choice;
        while (true) {
            System.out.println("\nStack Operations Menu (String Stack):");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display Stack");
            System.out.println("4. Count Elements in Stack");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // Push
                    System.out.print("Enter the value to push onto the stack: ");
                    String value = scanner.nextLine();
                    stack.Push(value);
                    System.out.println("Pushed \"" + value + "\"");
                    break;

                case 2: // Pop
                    String result = stack.Pop();
                    if (result != null) {
                        System.out.println("Popped: " + result);
                    }
                    break;

                case 3: // Display Stack
                    stack.Display();
                    break;

                case 4: // Count Elements
                    System.out.println("Number of elements in the stack: " + stack.Count());
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
// import java.util.Scanner;

// class Node<T> {
//     public T data;
//     public Node<T> next;

//     public Node(T x) {
//         data = x;
//         next = null;
//     }
// }

// class Stack<T> {
//     public Node<T> head;
//     public int iCount;

//     public Stack() {
//         head = null;
//         iCount = 0;
//     }

//     // Push a value onto the stack
//     public void Push(T no) {
//         Node<T> newn = new Node<>(no);

//         if (head == null) {
//             head = newn;
//         } else {
//             newn.next = head;
//             head = newn;
//         }
//         iCount++;
//     }

//     // Display the elements of the stack
//     public void Display() {
//         System.out.println("Elements of the Stack are:");
//         Node<T> temp = head;

//         if (temp == null) {
//             System.out.println("Stack is empty.");
//         } else {
//             while (temp != null) {
//                 System.out.println(temp.data);
//                 temp = temp.next;
//             }
//         }
//     }

//     // Count the number of elements in the stack
//     public int Count() {
//         return iCount;
//     }

//     // Pop a value from the stack
//     public T Pop() {
//         if (head == null) {
//             System.out.println("Stack is empty.");
//             return null; // Return null if stack is empty
//         }
        
//         T no = head.data;
//         head = head.next;
//         iCount--;
//         return no;
//     }
// }

// public class GenericStack {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int choice;
//         String input;
        
//         System.out.println("Enter the type of stack you want to use (1 - Integer, 2 - String): ");
//         choice = scanner.nextInt();
        
//         if (choice == 1) {
//             Stack<Integer> intStack = new Stack<>();
//             interactWithStack(scanner, intStack);
//         } else if (choice == 2) {
//             Stack<String> stringStack = new Stack<>();
//             interactWithStack(scanner, stringStack);
//         } else {
//             System.out.println("Invalid choice.");
//         }

//         scanner.close();
//     }

//     // Method to interact with the stack for different data types
//     public static <T> void interactWithStack(Scanner scanner, Stack<T> stack) {
//         int choice;
//         while (true) {
//             System.out.println("\nStack Operations Menu:");
//             System.out.println("1. Push");
//             System.out.println("2. Pop");
//             System.out.println("3. Display Stack");
//             System.out.println("4. Count Elements in Stack");
//             System.out.println("5. Exit");
//             System.out.print("Enter your choice: ");
//             choice = scanner.nextInt();
//             scanner.nextLine(); // Consume the newline character after the number input

//             switch (choice) {
//                 case 1: // Push
//                     System.out.print("Enter the value to push onto the stack: ");
//                     if (stack instanceof Stack<Integer>) {
//                         int value = scanner.nextInt();
//                         stack.Push((T) Integer.valueOf(value)); // Type casting for generic type
//                     } else if (stack instanceof Stack<String>) {
//                         String value = scanner.nextLine();
//                         stack.Push((T) value); // Type casting for generic type
//                     }
//                     System.out.println("Pushed the value onto the stack.");
//                     break;

//                 case 2: // Pop
//                     T result = stack.Pop();
//                     if (result != null) {
//                         System.out.println("Popped: " + result);
//                     }
//                     break;

//                 case 3: // Display Stack
//                     stack.Display();
//                     break;

//                 case 4: // Count Elements
//                     System.out.println("Number of elements in the stack: " + stack.Count());
//                     break;

//                 case 5: // Exit
//                     System.out.println("Exiting...");
//                     return;

//                 default:
//                     System.out.println("Invalid choice. Please try again.");
//             }
//         }
//     }
// }
