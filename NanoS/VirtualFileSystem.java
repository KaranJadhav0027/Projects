import java.util.*;
import java.io.*;

class VirtualFile {
    private String name;
    private StringBuilder content;
    private int pointer;

    public VirtualFile(String name) {
        this.name = name;
        this.content = new StringBuilder();
        this.pointer = 0;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return content.length();
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int position) {
        if (position < 0 || position > content.length()) {
            System.out.println("Error: Invalid position.");
        } else {
            pointer = position;
        }
    }

    public String getContent() {
        return content.toString();
    }

    public void writeContent(String data) {
        content.insert(pointer, data);
        pointer += data.length();
    }
}

class VirtualFileSystem {
    private Map<String, VirtualFile> files = new HashMap<>();
    private List<VirtualFile> openFiles = new ArrayList<>();

    public void man(String command) {
        Map<String, String> manual = new HashMap<>();
        manual.put("CreateFile", "CreateFile [filename] - Creates a new empty file.");
        manual.put("Rm_File", "Rm_File [filename] - Removes the specified file.");
        manual.put("ls", "ls - Lists all files.");
        manual.put("OpenFile", "OpenFile [filename] - Opens a file.");
        manual.put("CloseFile", "CloseFile [filename] - Closes a specific file.");
        manual.put("CloseAllFiles", "CloseAllFiles - Closes all opened files.");
        manual.put("ReadFile", "ReadFile [filename] - Reads the content of a file.");
        manual.put("WriteFile", "WriteFile [filename] - Writes data to a file.");
        manual.put("LseekFile", "LseekFile [filename] [position] - Moves the read pointer.");
        manual.put("Fstat_file", "Fstat_file [filename] - Displays file statistics.");
        manual.put("Fstat_all", "Fstat_all - Displays information of all files.");
        manual.put("help", "help - Displays the list of available commands.");
        manual.put("exit", "exit - Exits the virtual file system.");
        System.out.println(manual.getOrDefault(command, "No manual entry for " + command));
    }


    public void help() {
        System.out.println("Available commands:");
        System.out.println("  CreateFile [filename]      - Create a new empty file");
        System.out.println("  Rm_File [filename]         - Remove the specified file");
        System.out.println("  ls                         - List all files");
        System.out.println("  OpenFile [filename]        - Open a file");
        System.out.println("  CloseFile [filename]       - Close a specific file");
        System.out.println("  CloseAllFiles              - Close all opened files");
        System.out.println("  ReadFile [filename]        - Read the content of a file");
        System.out.println("  WriteFile [filename] [data]- Write data to a file");
        System.out.println("  LseekFile [filename] [pos] - Move the read pointer within a file");
        System.out.println("  Fstat_file [filename]      - Display file information");
        System.out.println("  Fstat_all                  - Display information of all files");
        System.out.println("  man [command]              - Get information about a specific command");
        System.out.println("  help                       - Show this help message");
        System.out.println("  exit                       - Exit the Virtual File System");
    }

    public void createfile(String name) {
        if (files.containsKey(name)) {
            System.out.println("Error: File already exists.");
        } else {
            files.put(name, new VirtualFile(name));
            System.out.println("File created: " + name);
        }
    }

    public void rm_file(String name) {
        if (files.remove(name) != null) {
            System.out.println("File deleted: " + name);
        } else {
            System.out.println("Error: File not found.");
        }
    }

    public void ls() {
        if (files.isEmpty()) {
            System.out.println("No files found.");
        } else {
            files.keySet().forEach(System.out::println);
        }
    }

    
    public void openfile(String name) {
        VirtualFile file = files.get(name);
        if (file != null) {
            openFiles.add(file);
            System.out.println("File opened: " + name);
        } else {
            System.out.println("Error: File not found.");
        }
    }

    public void closefile(String name) {
        openFiles.removeIf(file -> file.getName().equals(name));
        System.out.println("File closed: " + name);
    }

    public void closeallfiles() {
        openFiles.clear();
        System.out.println("All files closed.");
    }


    // public void readFile(String name) {
    //     VirtualFile file = files.get(name);
    //     if (file != null) {
    //         System.out.println(file.getContent());
    //     } else {
    //         System.out.println("Error: File not found.");
    //     }
    // }

    public void readfile(String name) {
        VirtualFile file = files.get(name);
        if (file != null) {
            String content = file.getContent();
            if (content != null) {
                // Trim the content to avoid trailing null or unnecessary whitespaces
                content = content.trim();
                if (!content.isEmpty()) {
                    System.out.println(content);
                } else {
                    System.out.println("The file is empty.");
                }
            } else {
                System.out.println("Error: File content is null.");
            }
        } else {
            System.out.println("Error: File not found.");
        }
    }

    public void writefile(String name, String content) {
        VirtualFile file = files.get(name);
        if (file != null) {
            file.writeContent(content);
            System.out.println("Data written to file: " + name);
        } else {
            System.out.println("Error: File not found.");
        }
    }

    public void lseekfile(String name, int position) {
        VirtualFile file = files.get(name);
        if (file != null) {
            file.setPointer(position);
            System.out.println("Pointer moved to position: " + position);
        } else {
            System.out.println("Error: File not found.");
        }
    }

    // public void FstatFile(String name) {
    //     VirtualFile file = files.get(name);
    //     if (file != null) {
    //         System.out.println("File Name: " + file.getName());
    //         System.out.println("File Size: " + file.getSize() + " bytes");
    //         System.out.println("Read Pointer Position: " + file.getPointer());
    //     } else {
    //         System.out.println("Error: File not found.");
    //     }
    // }

    public void fstatfile(String name) {
        VirtualFile file = files.get(name);
    
        // Print a table header if the file exists
        if (file != null) {
            // Printing header for the table
            System.out.println("\n File Information");
            System.out.println("------------------------------------------------------------");
            System.out.println("File Name\t\tFile Size\tRead Pointer Position");
            System.out.println("------------------------------------------------------------");
    
            // Printing the file information in a table format
            System.out.printf("%-16s\t%-10d\t%-20d\n", file.getName(), file.getSize(), file.getPointer());
    
            System.out.println("------------------------------------------------------------");
        } else {
            // Error message if file is not found
            System.out.println("Error: File not found.");
        }
    }

    // public void Fstat_all() {
    //     if (files.isEmpty()) {
    //         System.out.println("No files available.");
    //         return;
    //     }
    //     System.out.println("File Statistics:");
    //     for (VirtualFile file : files.values()) {
    //         System.out.println("--------------------------------");
    //         System.out.println("File Name: " + file.getName());
    //         System.out.println("File Size: " + file.getSize() + " bytes");
    //         System.out.println("Pointer Position: " + file.getPointer());
    //     }
    // }

    public void fstat_all() {
        if (files.isEmpty()) {
            System.out.println("No files available.");
            return;
        }
    
        // Print table header
        System.out.println("\n File Statistics");
        System.out.println("------------------------------------------------------------");
        System.out.println("File Name\t\tFile Size\tRead Pointer Position");
        System.out.println("------------------------------------------------------------");
    
        // Iterate over all files and print their statistics
        for (VirtualFile file : files.values()) {
            // Print each file's details in a table row
            System.out.printf("%-16s\t%-10d\t%-20d\n", file.getName(), file.getSize(), file.getPointer());
        }
    
        System.out.println("------------------------------------------------------------");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VirtualFileSystem vfs = new VirtualFileSystem();

        System.out.println("Welcome to the Virtual File System. Type 'help' to see available commands.");

        while (true) {
            System.out.print("Virchual Java Environment > ");
            String[] input = scanner.nextLine().split(" ", 3);
            // String command = input[0];
            String command = input[0].toLowerCase();

            String argument1 = input.length > 1 ? input[1] : null;
            String argument2 = input.length > 2 ? input[2] : null;

            if (command.equals("exit")) {
                System.out.println("Exiting Virtual File System.");
                break;
            }

            try {
                
                                switch (command) {
                    case "createfile":
                        vfs.createfile(argument1);
                        break;
                    case "rm_file":
                        vfs.rm_file(argument1);
                        break;
                    case "ls":
                        vfs.ls();
                        break;
                    case "openfile":
                        vfs.openfile(argument1);
                        break;
                    case "closefile":
                        vfs.closefile(argument1);
                        break;
                    case "closeallfiles":
                        vfs.closeallfiles();
                        break;
                    case "readfile":
                        vfs.readfile(argument1);
                        break;
                    case "writefile":
                        vfs.writefile(argument1, argument2);
                        break;
                    case "lseekfile":
                        vfs.lseekfile(argument1, Integer.parseInt(argument2));
                        break;
                    case "fstat_file":
                        vfs.fstatfile(argument1);
                        break;
                    case "fstat_all":
                        vfs.fstat_all();
                        break;
                    case "man":
                        if (argument1 != null) {
                            vfs.man(argument1);
                        } else {
                            System.out.println("Usage: man [command]");
                        }
                        break;
                    case "help":
                        vfs.help();
                        break;
                    case "exit":
                        System.out.println("Exiting Virtual File System.");
                        return;
                    default:
                        System.out.println("Invalid command. Type 'help' for the list of commands.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}  
