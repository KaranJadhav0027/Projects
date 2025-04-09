import java.io.*;
import java.util.*;

class FileClass {

    // Packing method
    public static void packFiles(String DirName, String PackName) {
        int iRet = 0, iCount = 0;
        FileOutputStream fopackobj = null;
        FileInputStream fiobj = null;
        File fobj = new File(DirName);
        File Packobj = new File(PackName);
        boolean bret = false;
        String Header = "";

        try {
            // Creating the packed file
            bret = Packobj.createNewFile();
            if (bret) {
                System.out.println("Packed file gets successfully created with the name: " + PackName);
            } else {
                System.out.println("Unable to proceed as pack file is not created");
                return;
            }

            fopackobj = new FileOutputStream(Packobj);

            if (fobj.exists()) {
                System.out.println("Directory is successfully opened for the packing activity");

                File[] Arr = fobj.listFiles();
                byte[] Buffer = new byte[1024];

                // Iterate over files in the directory
                for (int i = 0; i < Arr.length; i++) {
                    if ((Arr[i].getName()).endsWith(".txt")) {
                        Header = Arr[i].getName() + " " + Arr[i].length();

                        // Padding the header to 100 bytes
                        for (int j = Header.length(); j < 100; j++) {
                            Header = Header + " ";
                        }

                        fopackobj.write(Header.getBytes(), 0, 100);

                        fiobj = new FileInputStream(Arr[i]);

                        // Write file content to packed file
                        while ((iRet = fiobj.read(Buffer)) != -1) {
                            fopackobj.write(Buffer, 0, iRet);
                        }

                        fiobj.close();
                        Header = "";
                        iCount++;
                    }
                }
                System.out.println("Total number of files packed: " + iCount);
                fopackobj.close();
            } else {
                System.out.println("There is no such directory");
            }

        } catch (Exception eobj) {
            System.out.println("Exception occurred: " + eobj);
        }
    }

    // Unpacking method
    public static void unpackFiles(String PackName) {
        int FileSize = 0, iRet = 0, iCount = 0;
        File fobj = new File(PackName);
        FileOutputStream foobj = null;
        FileInputStream fiobj = null;

        try {
            if (fobj.exists()) {
                fiobj = new FileInputStream(fobj);

                byte[] Header = new byte[100];
                String SHeader;

                // Read header and extract files
                while ((iRet = fiobj.read(Header)) != -1) {
                    SHeader = new String(Header).trim();
                    String[] Arr = SHeader.split(" ");
                    File fobjX = new File(Arr[0]);
                    fobjX.createNewFile();

                    System.out.println("File extracted with name: " + Arr[0]);

                    foobj = new FileOutputStream(fobjX);
                    FileSize = Integer.parseInt(Arr[1]);
                    byte[] Buffer = new byte[FileSize];

                    fiobj.read(Buffer);
                    foobj.write(Buffer, 0, FileSize);

                    foobj.close();
                    iCount++;
                }
                fiobj.close();
                System.out.println("Number of files successfully extracted: " + iCount);
            } else {
                System.out.println("There is no such packed file");
            }

        } catch (Exception eobj) {
            System.out.println("Exception occurred: " + eobj);
        }
    }
}

public class FilePackerUnpacker {

    public static void main(String Arg[]) {
        Scanner sobj = new Scanner(System.in);
        String DirName = "", PackName = "", action = "";

        try {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("-------------------- Packer Unpacker CUI Module ---------------------");
            System.out.println("---------------------------------------------------------------------");

            // Ask user for action: packing or unpacking
            System.out.println("Enter action (pack/unpack): ");
            action = sobj.nextLine().trim().toLowerCase();

            if ("pack".equals(action)) {
                // Packing process
                System.out.println("---------------------------- Packing Activity -----------------------");
                System.out.println("Enter the name of directory that you want to open for packing: ");
                DirName = sobj.nextLine();

                System.out.println("Enter the name of packed file that you want to create: ");
                PackName = sobj.nextLine();

                // Call FileClass to pack files
                FileClass.packFiles(DirName, PackName);

            } else if ("unpack".equals(action)) {
                // Unpacking process
                System.out.println("---------------------------- Unpacking Activity -----------------------");
                System.out.println("Enter the name of packed file that you want to unpack: ");
                PackName = sobj.nextLine();

                // Call FileClass to unpack files
                FileClass.unpackFiles(PackName);

            } else {
                System.out.println("Invalid action! Please choose either 'pack' or 'unpack'.");
            }

            System.out.println("---------------------------------------------------------------------");
            System.out.println("-------------- Thank you for using Packer-Unpacker ------------------");
            System.out.println("---------------------------------------------------------------------");

        } catch (Exception eobj) {
            System.out.println("Exception occurred: " + eobj);
        }
    }
}
