import java.net.*;
import java.io.*;
import java.awt.*;
//import java.awt.event.*;

class ServerAWT extends Frame implements ActionListener {
    TextArea chatDisplay;   // To display chat messages
    TextField inputField;   // To type messages to the client
    Button sendButton;      // Button to send messages
    Socket socket;
    PrintStream ps;
    BufferedReader br;
    String str;

    public ServerAWT() {
        // Create GUI components
        setTitle("Marvellous Server Chat");
        setSize(500, 400);
        setLayout(new BorderLayout());
        
        chatDisplay = new TextArea();
        chatDisplay.setEditable(false);
        add(chatDisplay, BorderLayout.CENTER);
        
        Panel bottomPanel = new Panel(new BorderLayout());
        inputField = new TextField();
        sendButton = new Button("Send");
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
        
        sendButton.addActionListener(this);
        inputField.addActionListener(this);

        // Close the application when the window is closed
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);

        try {
            // Setup server
            ServerSocket ssobj = new ServerSocket(2100);
            chatDisplay.append("Server is waiting for a client at port number 2100...\n");

            socket = ssobj.accept();  // Accept connection
            chatDisplay.append("Connection established with client.\n");

            ps = new PrintStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Start a thread to listen to client messages
            Thread clientListener = new Thread(() -> {
                try {
                    while ((str = br.readLine()) != null) {
                        chatDisplay.append("Client: " + str + "\n");
                    }
                } catch (Exception e) {
                    chatDisplay.append("Client disconnected.\n");
                }
            });
            clientListener.start();

        } catch (Exception e) {
            chatDisplay.append("Error: " + e.getMessage() + "\n");
        }
    }

    // Action listener for send button and input field
    public void actionPerformed(ActionEvent e) {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            ps.println(message);  // Send message to the client
            chatDisplay.append("You: " + message + "\n");
            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        new ServerAWT();
    }
}
