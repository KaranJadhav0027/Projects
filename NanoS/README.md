# NanoS – Java Data Structures & Virtual File System Suite

## 📌 Overview
**NanoS** is a comprehensive Java-based suite that demonstrates advanced concepts in **data structures**, **string manipulation**, and **file system simulation**.  
It contains modular, reusable components with both **CLI-based applications** and **object-oriented implementations**, making it suitable for academic, research, and real-world scenarios.

This project is designed with **clean code principles**, **reusability**, and **extensibility** in mind.

---

## 🚀 Features

### 1. **Generic Data Structure Implementations**
- **Generic Linked List** – Supports insertion, deletion, and traversal at various positions.
- **Generic Stack** – Implements push, pop, peek, and utility methods.
- **Generic Queue** – Implements enqueue, dequeue, peek, and traversal.
- **Generic Tree** – Allows creation and traversal of generic trees.

### 2. **String Operations**
- Over **19 advanced string manipulation functions**, including:
  - Palindrome checking
  - Substring extraction
  - String reversal
  - Word counting
  - Case conversion
  - And more…

### 3. **Array Operations**
- Includes numerous array manipulation utilities:
  - Sorting, shuffling, and reversing
  - Removing duplicates
  - Checking for palindromes
  - Mathematical transformations

### 4. **Virtual File System (VFS)**
- Simulates a **Linux-like command-line file system** in Java.
- Supported commands:
  - `CreateFile`
  - `ReadFile`
  - `WriteFile`
  - `Rm_File`
  - `OpenFile`, `CloseFile`, `CloseAllFiles`
  - `ls`, `man`, `Fstat_file`, `LseekFile`
- Includes detailed **`man` command** for usage documentation.

---

## 🛠️ Tech Stack
- **Language:** Java (JDK 8+)
- **Paradigm:** Object-Oriented Programming (OOP)
- **Execution:** Command-Line Interface (CLI)

---

## 📂 Project Structure

 NanoS/
      -│── Array.java # Array manipulation utilities
      -│── GenericLinkedListApp.java # Generic linked list implementation
      -│── GenericStack.java # Generic stack implementation
      -│── GeneriQueue.java # Generic queue implementation
      -│── GenericTree.java # Generic tree implementation
      -│── StringOperationsApp.java # String manipulation utilities
      -│── VirtualFileSystem.java # CLI-based virtual file system
      -│── LinkedListInterface.java # Interface for linked list operations
      -│── MainApp.java # Central application entry point

---

## ⚙️ Installation & Setup
1. **Clone the Repository**
   ```bash
   git clone https://github.com/<your-username>/NanoS.git
   cd NanoS

2. **Compile the Java Files**
   
     javac  *.java

3. **Run the Main Application**

      java MainApp

--- 

## 📖 Usage
 
  - Main Menu will provide options to choose:
     - Data structure operations
     - String operations
     - Array operations
     - Virtual File System commands
       
  - Follow the CLI prompts or use the man command in VFS to get detailed instructions.
    ```bash
    > man CreateFile
    NAME
        CreateFile – Creates a new file in the VFS.
    USAGE
        CreateFile <filename> <permissions>

  ---

## 🧪 Example Commands
    
    > CreateFile notes.txt RW
    > WriteFile notes.txt
    > ReadFile notes.txt
    > ls
    > deleteAtPosition 3
    > reverseString "hello"

  ---

## 👨‍💻 Author

  - Karan Jadhav
  - Java Developer | Data Structures Enthusiast | System Design Learner
  -  📧 karanjadhav0027@gmail.com

---
