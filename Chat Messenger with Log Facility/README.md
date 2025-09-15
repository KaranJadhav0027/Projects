# 💬 Java AWT Client-Server Chat Application

## 📌 Overview
The **Client-Server Chat Application** is a Java-based project built using **AWT (Abstract Window Toolkit)** and **Socket Programming**.  
It enables **real-time communication** between a client and server over a TCP connection, with a **graphical user interface (GUI)** for interaction.

This project demonstrates concepts of **network programming**, **multi-threading**, and **event-driven GUI development** in Java.

---

## 🚀 Features
- **Client-Server Architecture** using TCP sockets.
- **Graphical User Interface (GUI)** built with **AWT**.
- **Real-time chat** between client and server.
- **Multi-threading** support for handling simultaneous read/write operations.
- **User-friendly interface** with text area for messages and input fields.

---

## 🛠️ Tech Stack
- **Language:** Java (JDK 8+)  
- **GUI Framework:** Java AWT  
- **Networking:** `java.net` (Socket, ServerSocket)  
- **Threading:** Multi-threaded communication  

---

## 📂 Project Structure
<pre>
     ClientServerChatAWT/
               │── ClientAWT.java # Client-side AWT-based chat application
               │── ServerAWT.java # Server-side AWT-based chat application
</pre>

  ---
  
## 1 Compile the Programs

    javac ClientAWT.java
    javac ServerAWT.java


## 2 Run the Server

    java ServerAWT

## 3  Run the Client

    java ClientAWT
    
  ---

 ## 📖 Usage

   - Start the server application first.

   - Launch the client application and connect to the server.

   - Use the GUI text field to type messages and press Send.

   - Messages will appear in the chat window on both sides.

---

## 🧪 Example Interaction

**Server Window:**

    Server started...
    Client connected.
    Client: Hello, Server!
    Server: Hi, Client! Welcome.

**Client Window:**

    Connected to server.
    Client: Hello, Server!
    Server: Hi, Client! Welcome.

  ---

  ## 👨‍💻 Author

    
    -Karan Jadhav
    📧 karanjadhav0027@gmail.com
     
---
