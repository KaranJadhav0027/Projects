# 📦 File Packer & Unpacker Utility

## 📌 Overview
The **File Packer & Unpacker** is a Java-based utility designed to:
- **Pack**: Combine multiple files from a given directory into a single packed file.
- **Unpack**: Extract individual files from a packed file back into their original form.

This tool is ideal for:
- Archiving related files together
- Reducing directory clutter
- Easy backup and restoration

---

## 🚀 Features
- **Pack Directory Files**: Select a directory, and all files are combined into a single packed file with headers for retrieval.
- **Unpack Packed File**: Reads headers from the packed file and recreates the original files.
- **Header Information**:
  - File Name
  - File Size
- **Robust Error Handling** for missing files, inaccessible directories, or corrupted packed files.
- **Cross-Platform Compatibility** (Java-based).

---

## 🛠️ Tech Stack
- **Language:** Java (JDK 8+)
- **I/O APIs:** `java.io.*`
- **Utilities:** `java.util.*`
- **Paradigm:** Procedural + Modular OOP

---

## 📂 Project Structure
   <pre>
   FilePackerUnpacker/
          │── FilePackerUnpacker.java # Main utility containing pack & unpack methods
  </pre>
  
---

## ⚙️ Installation & Setup
1. **Clone the Repository**
   ```bash
   git clone https://github.com/<your-username>/FilePackerUnpacker.git
   cd FilePackerUnpacker
2. Compile the Java Program

        javac FilePackerUnpacker.java
        Run the Application
       
 3.Run the Application
   
    java FilePackerUnpacker

  ---
## 📖 Usage
 The program can be run in two modes:

## 1️⃣ Packing Mode

    Enter Directory Name: MyFolder
    Enter Packed File Name: archive.pck
    Result: All files from MyFolder are stored inside archive.pck.

## 2️⃣ Unpacking Mode

    Enter Packed File Name: archive.pck
    Enter Output Directory Name: RestoredFolder
    Result: All files from archive.pck are restored into RestoredFolder.

---

## 🧪 Example
Packing:

    Packed file gets successfully created with the name: archive.pck
    Directory is successfully opened for the packing activity
    File packed: notes.txt
    File packed: image.jpg
    
Unpacking:

    Unpacking started...
    Extracted: notes.txt
    Extracted: image.jpg

  ---

## 👨‍💻 Author

  - Karan Jadhav
  - Java Developer | Systems Programmer
  -  📧 karanjadhav0027@gmail.com
---
