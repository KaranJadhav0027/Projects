import java.util.Scanner;
//##########################DoublyCricularList

class DoubleyNode<T> {
    public T data;
    public DoubleyNode<T> next;
    public DoubleyNode<T> prev;

    public DoubleyNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyCircularLinkedList<T> implements LinkedListInterface<T> {
    private DoubleyNode<T> head;
    private DoubleyNode<T> tail;
    private int count;

    public DoublyCircularLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public void insertFirst(T data) {
        DoubleyNode<T> newNode = new DoubleyNode<>(data);
        if (head == null) {
            head = tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        count++;
    }

    public void insertLast(T data) {
        DoubleyNode<T> newNode = new DoubleyNode<>(data);
        if (tail == null) {
            head = tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
        count++;
    }

    public void insertAtPos(T data, int pos) {
        if (pos < 1 || pos > count + 1) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            insertFirst(data);
        } else if (pos == count + 1) {
            insertLast(data);
        } else {
            DoubleyNode<T> newNode = new DoubleyNode<>(data);
            DoubleyNode<T> temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            count++;
        }
    }

    public void deleteFirst() {
        if (head == null)
            return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        count--;
    }

    public void deleteLast() {
        if (tail == null)
            return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        count--;
    }

    public void deleteAtPos(int pos) {
        if (pos < 1 || pos > count) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            deleteFirst();
        } else if (pos == count) {
            deleteLast();
        } else {
            DoubleyNode<T> temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
            count--;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        DoubleyNode<T> temp = head;
        System.out.print("Elements of the circular linked list: ");
        do {
            System.out.print("|" + temp.data + "|<=>");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public int count() {
        return count;
    }
}
// ########################DoublyLinkedList###########
// class Node<T> {
// public T data;
// public Node<T> next;
// public Node<T> prev;

// public Node(T data) {
// this.data = data;
// this.next = null;
// this.prev = null;
// }

// }

class DoublyLinkedList<T> implements LinkedListInterface<T> {
    private DoubleyNode<T> head;
    private DoubleyNode<T> tail;
    private int count;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public void insertFirst(T data) {
        DoubleyNode<T> newNode = new DoubleyNode<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        count++;
    }

    public void insertLast(T data) {
        DoubleyNode<T> newNode = new DoubleyNode<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
    }

    public void insertAtPos(T data, int pos) {
        if (pos < 1 || pos > count + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            insertFirst(data);
        } else if (pos == count + 1) {
            insertLast(data);
        } else {
            DoubleyNode<T> newNode = new DoubleyNode<>(data);
            DoubleyNode<T> temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            count++;
        }
    }

    public void deleteFirst() {
        if (head == null)
            return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        count--;
    }

    public void deleteLast() {
        if (tail == null)
            return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        count--;
    }

    public void deleteAtPos(int pos) {
        if (pos < 1 || pos > count) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            deleteFirst();
        } else if (pos == count) {
            deleteLast();
        } else {
            DoubleyNode<T> temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
            count--;
        }
    }

    public void display() {
        DoubleyNode<T> temp = head;
        System.out.print("Elements of the linked list: ");
        while (temp != null) {
            System.out.print("|" + temp.data + "|<=>");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public int count() {
        return count;
    }
}
// ############################################

class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList<T> implements LinkedListInterface<T> {
    private Node<T> head;
    private int count;

    public SinglyLinkedList() {
        head = null;
        count = 0;
    }

    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        count++;
    }

    public void insertLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        count++;
    }

    public void insertAtPos(T data, int pos) {
        if (pos < 1 || pos > count + 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (pos == 1) {
            insertFirst(data);
        } else if (pos == count + 1) {
            insertLast(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            count++;
        }
    }

    public void deleteFirst() {
        if (head == null)
            return;
        head = head.next;
        count--;
    }

    public void deleteLast() {
        if (head == null)
            return;
        if (head.next == null) {
            head = null;
        } else {
            Node<T> temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        count--;
    }

    public void deleteAtPos(int pos) {
        if (pos < 1 || pos > count) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            deleteFirst();
        } else if (pos == count) {
            deleteLast();
        } else {
            Node<T> temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            count--;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node<T> temp = head;
        System.out.print("Elements of the linked list: ");
        while (temp != null) {
            System.out.print("|" + temp.data + "|->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int count() {
        return count;
    }
}
// #########################################################
// class Node<T> {
// public T data;
// public Node<T> next;

// public Node(T data) {
// this.data = data;
// this.next = null;
// }
// }

class SinglyCircularLinkedList<T> implements LinkedListInterface<T> {
    private Node<T> head;
    private Node<T> tail;
    private int count;

    public SinglyCircularLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        count++;
    }

    public void insertLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        count++;
    }

    public void insertAtPos(T data, int pos) {

        if ((pos < 1) || (pos > count + 1)) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            insertFirst(data);
        } else if (pos == count + 1) {
            insertLast(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            count++;
        }
    }

    public void deleteFirst() {
        if (head == null)
            return;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        count--;
    }

    public void deleteLast() {
        if (head == null)
            return;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node<T> temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = head;
            tail = temp;
        }
        count--;
    }

    public void deleteAtPos(int pos) {
        if (pos < 1 || pos > count) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            deleteFirst();
        } else if (pos == count) {
            deleteLast();
        } else {
            Node<T> temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            count--;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node<T> temp = head;
        System.out.print("Elements of the circular linked list: ");
        do {
            System.out.print("|" + temp.data + "|->");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }

    public int count() {
        return count;
    }
}
// LinkedListInterface.java
// public interface LinkedListInterface<T> {
// void insertFirst(T value);
// void insertLast(T value);
// void insertAtPos(T value, int pos);
// void deleteFirst();
// void deleteLast();
// void deleteAtPos(int pos);
// void display();
// int count();
// } add

public class GenericLinkedListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedListInterface<Integer> currentList = null;
        SinglyLinkedList<Integer> singlyLL = new SinglyLinkedList<>();
        DoublyLinkedList<Integer> doublyLL = new DoublyLinkedList<>();
        SinglyCircularLinkedList<Integer> singlyCL = new SinglyCircularLinkedList<>();
        DoublyCircularLinkedList<Integer> doublyCL = new DoublyCircularLinkedList<>();

        // SinglyLinkedList<Integer> currentList = null; // To track the selected list
        int listType = 0; // To track the type of the selected list

        while (true) {
            System.out.println("Select Linked List Type:");
            System.out.println("1: Singly Linked List");
            System.out.println("2: Doubly Linked List");
            System.out.println("3: Singly Circular Linked List");
            System.out.println("4: Doubly Circular Linked List");
            System.out.println("5: Exit");
            System.out.print("Enter your choice: ");
            listType = scanner.nextInt();

            if (listType == 5)
                break;

            // Set the selected list based on the user input
            switch (listType) {
                case 1:
                    currentList = singlyLL;
                    break;
                case 2:
                    currentList = doublyLL;
                    break;
                case 3:
                    currentList = singlyCL;
                    break;
                case 4:
                    currentList = doublyCL;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            // Operations after selecting the list type
            while (true) {

                System.out.println("###################################################################");
                System.out.println("Select Operation:");
                System.out.println("1: Insert new element at first position");
                System.out.println("2: Insert new element at last position");
                System.out.println("3: Insert new element at given position");
                System.out.println("4: Delete the element from first position");
                System.out.println("5: Delete the element from last position");
                System.out.println("6: Delete the element from given position");
                System.out.println("7: Display the elements");
                System.out.println("8: Count Elements");
                System.out.println("9: Switch Linked List Type");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                System.out.println("###################################################################");

                int value = 0, pos = 0;
                switch (choice) {
                    case 1: // Insert into list
                        System.out.print("Enter value: ");
                        value = scanner.nextInt();

                        if (listType == 1) {
                            singlyLL.insertFirst(value);
                            System.out.println("Inserted " + value + " into singly linked list.");
                        } else if (listType == 2) {
                            doublyLL.insertFirst(value);
                            System.out.println("Inserted " + value + " into doubly linked list.");
                        } else if (listType == 3) {
                            singlyCL.insertFirst(value);
                            System.out.println("Inserted " + value + " into singly circular list.");
                        } else if (listType == 4) {
                            doublyCL.insertFirst(value);
                            System.out.println("Inserted " + value + " into doubly circular list.");
                        }
                        break;

                    case 2:
                        System.out.print("Enter value: ");
                        value = scanner.nextInt();
                        if (listType == 1)
                            singlyLL.insertLast(value);
                        else if (listType == 2)
                            doublyLL.insertLast(value);
                        else if (listType == 3)
                            singlyCL.insertLast(value);
                        else if (listType == 4)
                            doublyCL.insertLast(value);
                        break;
                    case 3:
                        System.out.print("Enter value: ");
                        value = scanner.nextInt();
                        System.out.print("Enter Position: ");
                        pos = scanner.nextInt();
                        if (listType == 1)
                            singlyLL.insertAtPos(value, pos);
                        else if (listType == 2)
                            doublyLL.insertAtPos(value, pos);
                        else if (listType == 3)
                            singlyCL.insertAtPos(value, pos);
                        else if (listType == 4)
                            doublyCL.insertAtPos(value, pos);
                        break;
                    case 4:
                        if (listType == 1)
                            singlyLL.deleteFirst();
                        else if (listType == 2)
                            doublyLL.deleteFirst();
                        else if (listType == 3)
                            singlyCL.deleteFirst();
                        else if (listType == 4)
                            doublyCL.deleteFirst();
                        break;
                    case 5:
                        if (listType == 1)
                            singlyLL.deleteLast();
                        else if (listType == 2)
                            doublyLL.deleteLast();
                        else if (listType == 3)
                            singlyCL.deleteLast();
                        else if (listType == 4)
                            doublyCL.deleteLast();
                        break;
                    case 6:
                        System.out.print("Enter Position: ");
                        pos = scanner.nextInt();
                        if (listType == 1)
                            singlyLL.deleteAtPos(pos);
                        else if (listType == 2)
                            doublyLL.deleteAtPos(pos);
                        else if (listType == 3)
                            singlyCL.deleteAtPos(pos);
                        else if (listType == 4)
                            doublyCL.deleteAtPos(pos);
                        break;
                    case 7:
                        if (listType == 1)
                            singlyLL.display();
                        else if (listType == 2)
                            doublyLL.display();
                        else if (listType == 3)
                            singlyCL.display();
                        else if (listType == 4)
                            doublyCL.display();
                        break;
                    case 8:
                        if (listType == 1)
                            System.out.println(singlyLL.count());
                        else if (listType == 2)
                            System.out.println(doublyLL.count());
                        else if (listType == 3)
                            System.out.println(singlyCL.count());
                        else if (listType == 4)
                            System.out.println(doublyCL.count());
                        break;
                    case 9:
                        // Break from the current operations loop to select a new list
                        break;
                    default:
                        System.out.println("Invalid operation. Please try again.");
                        continue;
                }
                if (choice == 9) {
                    break; // Exit the current operation loop if the user wants to switch lists
                }

            }
        }
        scanner.close();
    }
}
