# 🗂️ Customised Virtual File System (VFS)

## 📌 Overview
The **Customised Virtual File System (VFS)** is a command-line based simulation of a Linux-like file handling system, built in **C++**.  
It provides functionality similar to a real operating system’s file system, including **file creation, deletion, reading, writing, and metadata management**, all within a user-defined shell.

This project is designed to **strengthen OS concepts**, **system programming skills**, and demonstrate **custom file handling using data structures like inode tables, file tables, and superblocks**.

---

## 🚀 Features
- **File Management Commands:**
  - `create` → Create a new regular file with permissions.
  - `open` → Open an existing file in read/write mode.
  - `close` / `closeall` → Close one or all open files.
  - `rm` → Remove (delete) a file.
  - `truncate` → Remove all contents of a file.

- **I/O Operations:**
  - `read` → Read content from a file.
  - `write` → Write data into a file.
  - `lseek` → Modify file offsets (similar to `seek` in Linux).

- **File Metadata & Info:**
  - `ls` → List all files with details.
  - `stat` → Display file info using file name.
  - `fstat` → Display file info using file descriptor.

- **Utility Commands:**
  - `help` → List available commands.
  - `man <command>` → Show manual page for a command.
  - `clear` → Clear the console.
  - `exit` → Terminate the VFS.

---

## 🛠️ Tech Stack
- **Language:** C++  
- **Paradigms:** Procedural + Object-Oriented Concepts  
- **Core Concepts Used:**  
  - Inodes & Superblock simulation  
  - User File Descriptor Table (UFDT)  
  - File Table for open files  
  - Buffer management for read/write operations  

---

## 📂 Project Structure

    CustomisedVirtualFileSystem/
       │── CustomisedVirtualFileSystem.CPP # Main source code of the VFS
---

## ⚙️ Installation & Setup
1. **Clone the Repository**
  
       git clone https://github.com/<your-username>/CustomisedVirtualFileSystem.git
       cd CustomisedVirtualFileSystem

2. **Compile the Program**

       g++ CustomisedVirtualFileSystem.CPP -o vfs
   
3. **Run the Program**

        ./vfs
---

## 📖 Usage

     > create demo.txt 3
    File is Successfully created with file descriptor : 0
    
    > open demo.txt 3
    File is successfully opened with file description : 0
    
    > write demo.txt
    Enter the Data :
    Hello VFS World!
    
    > read demo.txt 20
    Hello VFS World!
    
    > ls
    File Name      Inode No    File Size    Link Count
    --------------------------------------------------
    demo.txt       1           1024         1

  ---

## 👨‍💻 Author

  - Karan Jadhav
  - Systems Programmer
  -  📧 karanjadhav0027@gmail.com
---
