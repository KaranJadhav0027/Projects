import java.util.Scanner;

class QueueNode<T> {
    public T data;
    public QueueNode<T> next;

    public QueueNode(T x) {
        data = x;
        next = null;
    }
}

class Queue<T> {
    public QueueNode<T> head;
    public int iCount;

    public Queue() {
        head = null;
        iCount = 0;
    }

    // Enqueue method to add an element to the queue
    public void Enqueue(T no) {
        QueueNode<T> newn = new QueueNode<>(no);

        if (head == null) {
            head = newn;
        } else {
            QueueNode<T> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newn;
        }
        iCount++;
    }

    // Display the elements in the queue
    public void Display() {
        System.out.println("Elements of the Queue are: ");
        QueueNode<T> temp = head;

        while (temp != null) {
             System.out.println("###########################################");
            System.out.print("|" + temp.data + "|->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Return the number of elements in the queue
    public int Count() {
         System.out.println("###########################################");
        return iCount;
    }

    // Dequeue method to remove an element from the queue
    public T Dequeue() {
        T no = null;

        if (head == null) {
            System.out.println("Queue is empty");
            return null;
        } else if (head.next == null) {
            no = head.data;
            head = null;
        } else {
            no = head.data;
            head = head.next;
        }
        iCount--;
        return no;
    }
}

public class GeneriQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of queue you want to use (1 - Integer, 2 - String): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice == 1) {
            Queue<Integer> intQueue = new Queue<>();
            operateIntegerQueue(scanner, intQueue);
        } else if (choice == 2) {
            Queue<String> stringQueue = new Queue<>();
            operateStringQueue(scanner, stringQueue);
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    // Method to operate on Integer queue
    public static void operateIntegerQueue(Scanner scanner, Queue<Integer> queue) {
        int choice;
        while (true) {
            System.out.println("\nQueue Operations Menu (Integer Queue):");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Count Elements in Queue");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // Enqueue
                    System.out.print("Enter the value to enqueue: ");
                    int value = scanner.nextInt();
                    queue.Enqueue(value);
                    System.out.println("Enqueued " + value);
                    break;

                case 2: // Dequeue
                    Integer result = queue.Dequeue();
                    if (result != null) {
                        System.out.println("Dequeued: " + result);
                    }
                    break;

                case 3: // Display Queue
                    queue.Display();
                    break;

                case 4: // Count Elements
                    System.out.println("Number of elements in the queue: " + queue.Count());
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to operate on String queue
    public static void operateStringQueue(Scanner scanner, Queue<String> queue) {
        int choice;
        while (true) {
            System.out.println("\nQueue Operations Menu (String Queue):");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Count Elements in Queue");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // Enqueue
                    System.out.print("Enter the value to enqueue: ");
                    String value = scanner.nextLine();
                    queue.Enqueue(value);
                    System.out.println("Enqueued \"" + value + "\"");
                    break;

                case 2: // Dequeue
                    String result = queue.Dequeue();
                    if (result != null) {
                        System.out.println("Dequeued: " + result);
                    }
                    break;

                case 3: // Display Queue
                    queue.Display();
                    break;

                case 4: // Count Elements
                    System.out.println("Number of elements in the queue: " + queue.Count());
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

// class Queue<T> {
//     public Node<T> head;
//     public int iCount;

//     public Queue() {
//         head = null;
//         iCount = 0;
//     }

//     // Enqueue method to add an element to the queue
//     public void Enqueue(T no) {
//         Node<T> newn = new Node<>(no);

//         if (head == null) {
//             head = newn;
//         } else {
//             Node<T> temp = head;

//             while (temp.next != null) {
//                 temp = temp.next;
//             }

//             temp.next = newn;
//         }
//         iCount++;
//     }

//     // Display the elements in the queue
//     public void Display() {
//         System.out.println("Elements of the Queue are: ");
//         Node<T> temp = head;

//         while (temp != null) {
//             System.out.print("|" + temp.data + "|->");
//             temp = temp.next;
//         }
//         System.out.println("null");
//     }

//     // Return the number of elements in the queue
//     public int Count() {
//         return iCount;
//     }

//     // Dequeue method to remove an element from the queue
//     public T Dequeue() {
//         T no = null;

//         if (head == null) {
//             System.out.println("Queue is empty");
//             return null;
//         } else if (head.next == null) {
//             no = head.data;
//             head = null;
//         } else {
//             no = head.data;
//             head = head.next;
//         }
//         iCount--;
//         return no;
//     }
// }

// public class GeneriQueue {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         Queue<Integer> intQueue = new Queue<>(); // Integer queue
//         Queue<String> stringQueue = new Queue<>(); // String queue

//         System.out.println("Enter the type of queue you want to use (1 - Integer, 2 - String): ");
//         int choice = scanner.nextInt();
//         scanner.nextLine(); // Consume the newline character

//         // Use different queues based on the user's choice
//         if (choice == 1) {
//             intQueue = new Queue<>();
//             operateQueue(scanner, intQueue);
//         } else if (choice == 2) {
//             stringQueue = new Queue<>();
//             operateQueue(scanner, stringQueue);
//         } else {
//             System.out.println("Invalid choice.");
//         }

//         scanner.close();
//     }

//     // Method to operate on a generic queue
//     public static <T> void operateQueue(Scanner scanner, Queue<T> queue) {
//         int choice;
//         while (true) {
//             System.out.println("\nQueue Operations Menu:");
//             System.out.println("1. Enqueue");
//             System.out.println("2. Dequeue");
//             System.out.println("3. Display Queue");
//             System.out.println("4. Count Elements in Queue");
//             System.out.println("5. Exit");

//             System.out.print("Enter your choice: ");
//             choice = scanner.nextInt();
//             scanner.nextLine(); // Consume the newline character

//             switch (choice) {
//                 case 1: // Enqueue
//                     System.out.print("Enter the value to enqueue: ");
//                     if (queue instanceof Queue<Integer>) {
//                         int value = scanner.nextInt();
//                         queue.Enqueue((T) Integer.valueOf(value)); // Type casting for generic type
//                     } else if (queue instanceof Queue<String>) {
//                         String value = scanner.nextLine();
//                         queue.Enqueue((T) value); // Type casting for generic type
//                     }
//                     System.out.println("Enqueued value");
//                     break;

//                 case 2: // Dequeue
//                     T result = queue.Dequeue();
//                     if (result != null) {
//                         System.out.println("Dequeued: " + result);
//                     }
//                     break;

//                 case 3: // Display Queue
//                     queue.Display();
//                     break;

//                 case 4: // Count Elements
//                     System.out.println("Number of elements in the queue: " + queue.Count());
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
