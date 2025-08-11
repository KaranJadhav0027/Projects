import java.util.ArrayList;
import java.util.Scanner;

class GenericTree {

    // Node class for the generic tree
    static class Node {
        int data;
        ArrayList<Node> children;

        Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    static class Tree {

        Node root;

        Tree() {
            root = null;
        }

        // Insert a new node into the tree
        void insert(Node parent, int value) {
            Node newNode = new Node(value);
            if (parent == null) {
                root = newNode; // If the tree is empty, this becomes the root
            } else {
                parent.children.add(newNode); // Otherwise, add it to the parent's children
            }
        }

        // Preorder Traversal (Root -> Children)
        void preorder(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                for (Node child : node.children) {
                    preorder(child);
                }
            }
        }

        // Postorder Traversal (Children -> Root)
        void postorder(Node node) {
            if (node != null) {
                for (Node child : node.children) {
                    postorder(child);
                }
                System.out.print(node.data + " ");
            }
        }

        // Inorder Traversal (Not traditionally defined for generic trees)
        // But you can define your own Inorder based on some conditions
        void inorder(Node node) {
            if (node != null) {
                int n = node.children.size();
                if (n > 0) {
                    inorder(node.children.get(0)); // Visit the first child first (for example)
                }
                System.out.print(node.data + " ");
                for (int i = 1; i < n; i++) {
                    inorder(node.children.get(i));
                }
            }
        }

        // Search for a node with a specific value
        boolean search(Node node, int value) {
            if (node == null) return false;

            if (node.data == value) {
                return true;
            }
            for (Node child : node.children) {
                if (search(child, value)) {
                    return true;
                }
            }
            return false;
        }

        // Count total number of nodes
        int countNodes(Node node) {
            if (node == null) {
                return 0;
            }
            int count = 1; // Count the current node
            for (Node child : node.children) {
                count += countNodes(child); // Count recursively for each child
            }
            return count;
        }

        // Count leaf nodes (Nodes with no children)
        int countLeafNodes(Node node) {
            if (node == null) {
                return 0;
            }
            if (node.children.isEmpty()) {
                return 1; // This is a leaf node
            }
            int count = 0;
            for (Node child : node.children) {
                count += countLeafNodes(child); // Recursively count leaf nodes in children
            }
            return count;
        }
    }

    // Function to display the help menu
    public static void help() {
        System.out.println("\nAvailable Operations:");
        System.out.println("1. Insert - Insert a node into the tree.");
        System.out.println("2. Preorder Traversal - Perform a preorder traversal of the tree.");
        System.out.println("3. Postorder Traversal - Perform a postorder traversal of the tree.");
        System.out.println("4. Inorder Traversal - Perform an inorder traversal of the tree.");
        System.out.println("5. Search - Search for a node in the tree.");
        System.out.println("6. Count Nodes - Count and display the total number of nodes.");
        System.out.println("7. Count Leaf Nodes - Count and display the number of leaf nodes.");
        System.out.println("8. Exit - Exit the program.");
        System.out.println("9. Help - Display this help menu.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree tree = new Tree();
        Node rootNode = null;
        int choice;

        // Displaying the help menu initially
        help();

        // Ask the user how many nodes they want to insert
        System.out.println("Enter the number of nodes you want to insert:");
        int numberOfNodes = scanner.nextInt();

        // Insert the nodes
        for (int i = 0; i < numberOfNodes; i++) {
            System.out.println("Enter value for node " + (i + 1) + ":");
            int value = scanner.nextInt();

            if (rootNode == null) {
                tree.insert(null, value); // First node becomes the root
                rootNode = tree.root;
                System.out.println("Root node " + value + " inserted.");
            } else {
                System.out.println("Enter parent node value for node " + (i + 1) + ":");
                int parentValue = scanner.nextInt();
                Node parentNode = findNode(rootNode, parentValue);
                if (parentNode != null) {
                    tree.insert(parentNode, value);
                    System.out.println(value + " inserted under parent " + parentValue);
                } else {
                    System.out.println("Parent node " + parentValue + " not found.");
                }
            }
        }

        // After insertion, continue with other operations
        while (true) {
            System.out.println("\nChoose an operation (Enter a number):");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Insert Operation
                    System.out.println("Enter value to insert:");
                    int value = scanner.nextInt();
                    if (rootNode == null) {
                        tree.insert(null, value); // First node becomes the root
                        rootNode = tree.root;
                    } else {
                        System.out.println("Enter parent node value:");
                        int parentValue = scanner.nextInt();
                        Node parentNode = findNode(rootNode, parentValue);
                        if (parentNode != null) {
                            tree.insert(parentNode, value);
                            System.out.println(value + " inserted under parent " + parentValue);
                        } else {
                            System.out.println("Parent node not found.");
                        }
                    }
                    break;

                case 2:
                    // Preorder Traversal
                    System.out.println("Preorder Traversal:");
                    tree.preorder(rootNode);
                    break;

                case 3:
                    // Postorder Traversal
                    System.out.println("Postorder Traversal:");
                    tree.postorder(rootNode);
                    break;

                case 4:
                    // Inorder Traversal (Custom defined for the generic tree)
                    System.out.println("Inorder Traversal:");
                    tree.inorder(rootNode);
                    break;

                case 5:
                    // Search Operation
                    System.out.println("Enter value to search:");
                    int searchValue = scanner.nextInt();
                    if (tree.search(rootNode, searchValue)) {
                        System.out.println(searchValue + " is present in the tree.");
                    } else {
                        System.out.println(searchValue + " is not present in the tree.");
                    }
                    break;

                case 6:
                    // Count Nodes
                    System.out.println("Total number of nodes: " + tree.countNodes(rootNode));
                    break;

                case 7:
                    // Count Leaf Nodes
                    System.out.println("Total number of leaf nodes: " + tree.countLeafNodes(rootNode));
                    break;

                case 8:
                    // Exit
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                case 9:
                    // Help
                    help();
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
    }

    // Helper method to find a node with a given value in the tree
    public static Node findNode(Node node, int value) {
        if (node == null) return null;

        if (node.data == value) {
            return node;
        }
        for (Node child : node.children) {
            Node result = findNode(child, value);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
