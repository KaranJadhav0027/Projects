# 📚 Generic Standard Library for Linked Lists (C++)

## 📌 Overview
The **Generic Standard Library (GSL)** is a C++ implementation of various **Linked List data structures** using **templates** for type-generic programming.  
It provides reusable, efficient, and easy-to-use implementations for:

- Singly Linear Linked List (SLL)  
- Doubly Linear Linked List (DLL)  
- Singly Circular Linked List (SCLL)  
- Doubly Circular Linked List (DCLL)  

This project is designed to strengthen **data structure knowledge**, demonstrate **template-based programming**, and provide a **menu-driven CLI interface** to test operations dynamically.

---

## 🚀 Features
Each linked list type supports the following operations:

- **Insertion**
  - At First
  - At Last
  - At Specific Position

- **Deletion**
  - From First
  - From Last
  - From Specific Position

- **Utility Operations**
  - Display elements
  - Count elements

---

## 🛠️ Tech Stack
- **Language:** C++ (C++11+)  
- **Paradigm:** Object-Oriented Programming with Templates  
- **Core Concepts Used:**  
  - Function Templates  
  - Linked List Data Structures (SLL, DLL, SCLL, DCLL)  
  - Generic Programming  
  - Menu-Driven CLI  

---

## 📂 Project Structure

<pre>
   GenericStandardLibrary/
                          │── GenericStandardLibrary.cpp # Implementation of Generic Linked List Library
</pre>

---

## ⚙️ Installation & Setup

1. **Compile the Program**

       g++ GenericStandardLibrary.cpp -o gsl

2. **Run the program** 

       ./gsl

   ---

## 📖 Usage

 1. **Select Linked List Type**

        1. Singly Linked List
        2. Doubly Linked List
        3. Singly Circular Linked List
        4. Doubly Circular Linked List
        5. Exit
   
 2. **Select Operation**

        1. Insert First
        2. Insert Last
        3. Insert At Position
        4. Delete First
        5. Delete Last
        6. Delete At Position
        7. Display Elements
        8. Count Elements

    ---

## 🧪 Example

    ###################################################################
    Select Linked List Type:
    1. Singly Linked List
    2. Doubly Linked List
    3. Singly Circular Linked List
    4. Doubly Circular Linked List
    5. Exit
    Enter your choice: 1
    ###################################################################
    
    Select Operation:
    1 : Insert new element at first position
    2 : Insert new element at last position
    3 : Insert new element at given position
    4 : Delete the element from first position
    ...
    Enter your choice: 1
    Enter the value to insert: 50

    Elements of LinkedList are :
    | 50 | -> NULL

  ## 👨‍💻 Author

  - Karan Jadhav
  - Java Developer | Data Structures Enthusiast | System Design Learner
  -  📧 karanjadhav0027@gmail.com

---
