# 🔢 Array Operations Utility (Java)

## 📌 Overview
The **Array Operations Utility** is a Java-based application that provides a comprehensive set of **array manipulation functions**.  
It includes mathematical, logical, and structural operations, making it a handy library for both learning and practical use in Java projects.

This project is designed with **reusability and modularity** in mind, allowing developers to easily integrate these utilities in larger applications.

---

## 🚀 Features
The `Array` class includes more than **30 array functions**, such as:

- **Basic Operations**
  - Find Maximum & Minimum
  - Calculate Sum & Average
  - Count Elements
  - Display Elements

- **Transformation**
  - Reverse Array
  - Shuffle Elements
  - Square or Double Elements
  - Negate Elements

- **Analysis**
  - Check if Sorted
  - Check if Palindrome
  - Find Frequency of Elements

- **Modification**
  - Remove Duplicates
  - Remove Zeros
  - Split Array
  - Get SubArray

- **Sorting**
  - Bubble Sort
  - Descending Sort

---

## 🛠️ Tech Stack
- **Language:** Java (JDK 8+)
- **Paradigm:** Object-Oriented Programming (OOP)
- **Packages Used:** `java.util.*`, `java.util.stream.*`

---

## 📂 Project Structure

<pre>
  ArrayOperationsApp/
                   │── Array.java # Utility class implementing 30+ array manipulation methods
</pre>
---

## ⚙️ Installation & Setup

 1. **Compile the Program**

         javac Array.java
 2. **Run Your Application**

         java Array
---
## 📖 Usage

     public class MainApp {
    public static void main(String[] args) {
        Array.array = new int[] {10, 20, 30, 20, 10};

        System.out.println("Max: " + Array.findMax());         // 30
        System.out.println("Min: " + Array.findMin());         // 10
        System.out.println("Sum: " + Array.calculateSum());    // 90
        System.out.println("Palindrome: " + Array.isPalindromeArray()); // true

        Array.reverseArray();
        System.out.println("Reversed: " + Arrays.toString(Array.array));
    }
    }

---
## 🧪 Example Output

       Max: 30
    Min: 10
    Sum: 90
    Palindrome: true
    Reversed: [10, 20, 30, 20, 10]

---

  ## 👨‍💻 Author

  - Karan Jadhav
  - Java Developer | Data Structures Enthusiast | System Design Learner
  -  📧 karanjadhav0027@gmail.com

---
    
