import java.util.*;
import java.util.stream.*;

public class Array {
    public static int[] array = {};

    // 1. Find Maximum
    public static int findMax() {
        return Arrays.stream(array).max().orElse(Integer.MIN_VALUE);
    }

    // 2. Find Minimum
    public static int findMin() {
        return Arrays.stream(array).min().orElse(Integer.MAX_VALUE);
    }

    // 3. Calculate Sum
    public static int calculateSum() {
        return Arrays.stream(array).sum();
    }

    // 4. Calculate Average
    public static double calculateAverage() {
        return array.length == 0 ? 0 : (double) calculateSum() / array.length;
    }

    // 5. Reverse Array
    public static void reverseArray() {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println("Array reversed.");
    }

    // 6. Check if Sorted
    public static boolean isSorted() {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) return false;
        }
        return true;
    }

    // 7. Linear Search
    public static int linearSearch(int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) return i;
        }
        return -1;
    }

    // 8. Binary Search (assumes sorted array)
    public static int binarySearch(int key) {
        return Arrays.binarySearch(array, key);
    }

    // 9. Copy Array
    public static int[] copyArray() {
        return Arrays.copyOf(array, array.length);
    }

    // 10. Merge Arrays
    public static void mergeArrays(int[] other) {
        int[] merged = new int[array.length + other.length];
        System.arraycopy(array, 0, merged, 0, array.length);
        System.arraycopy(other, 0, merged, array.length, other.length);
        array = merged;
        System.out.println("Arrays merged.");
    }

    // 11. Insert at Index
    public static void insertAt(int index, int value) {
        if (index < 0 || index > array.length) {
            System.out.println("Invalid index");
            return;
        }
        int[] newArr = new int[array.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == index) newArr[i] = value;
            else newArr[i] = array[j++];
        }
        array = newArr;
        System.out.println("Inserted " + value + " at index " + index);
    }

    // 12. Delete at Index
    public static void deleteAt(int index) {
        if (index < 0 || index >= array.length) {
            System.out.println("Invalid index");
            return;
        }
        int[] newArr = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) newArr[j++] = array[i];
        }
        array = newArr;
        System.out.println("Deleted element at index " + index);
    }

    // 13. Count Occurrences
    public static long countOccurrences(int value) {
        return Arrays.stream(array).filter(i -> i == value).count();
    }

    // 14. Remove Duplicates
    public static void removeDuplicates() {
        array = Arrays.stream(array).distinct().toArray();
        System.out.println("Duplicates removed.");
    }

    // 15. Sort Ascending
    public static void sortAscending() {
        Arrays.sort(array);
        System.out.println("Sorted in ascending order.");
    }

    // 16. Sort Descending
    public static void sortDescending() {
        array = Arrays.stream(array).boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();
        System.out.println("Sorted in descending order.");
    }

    // 17. Even Numbers
    public static int[] evenNumbers() {
        return Arrays.stream(array).filter(i -> i % 2 == 0).toArray();
    }

    // 18. Odd Numbers
    public static int[] oddNumbers() {
        return Arrays.stream(array).filter(i -> i % 2 != 0).toArray();
    }

    // 19. Rotate Left
    public static void rotateLeft(int positions) {
        if (array == null || array.length == 0) {
            System.out.println("Array is empty.");
            return;
        }
        int n = array.length;
        positions = positions % n; // to handle positions > array.length
        if (positions < 0) positions += n;
    
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[i] = array[(i + positions) % n];
        }
        array = rotated;
    }
    
    // 20. Rotate Right
    public static void rotateRight(int positions) {
        if (array == null || array.length == 0) {
            System.out.println("Array is empty.");
            return;
        }
        int n = array.length;
        positions = positions % n;
        if (positions < 0) positions += n;
    
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + positions) % n] = array[i];
        }
        array = rotated;
    }
    // 21 . ReplaceArrayElements
    public static void replaceArrayElements(int oldVal, int newVal) {
        if (array == null || array.length == 0) {
            System.out.println("Array is empty.");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == oldVal) {
                array[i] = newVal;
            }
        }
    }
    // 22. Serch
    public static int search(int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    // 23. EqualArrays
    public static boolean equalArrays(int[] otherArray) {
        if (array == null || otherArray == null) return false;
        if (array.length != otherArray.length) return false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != otherArray[i]) return false;
        }
        return true;
    }

    // Function 24: getSubArray
    public static int[] getSubArray(int[] array, int start, int end) {
        if (start < 0 || end > array.length || start > end) return new int[0];
        return Arrays.copyOfRange(array, start, end);
    }

    // Function 25: splitArray
    public static int[][] splitArray(int[] array, int parts) {
        int length = array.length / parts;
        int[][] result = new int[parts][];
        for (int i = 0; i < parts; i++) {
            int start = i * length;
            int end = (i == parts - 1) ? array.length : start + length;
            result[i] = Arrays.copyOfRange(array, start, end);
        }
        return result;
    }

    

    // Function 26: isPalindromeArray
    public static boolean isPalindromeArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) return false;
        }
        return true;
    }

    // Function 27: squareElements
    public static int[] squareElements(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i] * array[i];
        }
        return result;
    }

    // Function 28: negateElements
    public static int[] negateElements(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = -array[i];
        }
        return result;
    }

    // Function 29: doubleValues
    public static int[] doubleValues(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i] * 2;
        }
        return result;
    }

  

    // Function 30: removeZeros
    public static int[] removeZeros(int[] array) {
        return Arrays.stream(array).filter(num -> num != 0).toArray();
    }

    // Function 31: shuffleArray
    public static void shuffleArray(int[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // Function 32: bubbleSort
    public static int[] bubbleSort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        for (int i = 0; i < result.length - 1; i++) {
            for (int j = 0; j < result.length - 1 - i; j++) {
                if (result[j] > result[j + 1]) {
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        return result;
    }

    // Help
    public static void help() {
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Available commands:");
        System.out.println(" set <values>     :Set the array elements (e.g., set 1,2,3)");
        System.out.println(" print            :Print the array");
        System.out.println("findMax           :Returns the maximum value in the array.");
        System.out.println("findMin           :Returns the minimum value in the array.");
        System.out.println("calculateSum      :Returns the sum of all array elements.");
        System.out.println("calculateAverage :Returns the average of array elements.");
        System.out.println("reverseArray     :Reverses the array.");
        System.out.println("isSorted         : Checks if the array is sorted in ascending order.");
        System.out.println("linearSearch <key>:Searches for an element using linear search.");
        System.out.println("binarySearch <key>:Searches for an element in a sorted array using binary search.");
        System.out.println("copyArray         :Returns a new copy of the array.");
        System.out.println("mergeArrays <array1> <array2>:Merges two arrays.");
        System.out.println("insertAt <index> <value> :Inserts a value at a specified index.");
        System.out.println("deleteAt <index>  :Deletes the element at the specified index.");
        System.out.println("countOccurrences <value> :Counts occurrences of a value.");
        System.out.println("removeDuplicates :Removes duplicate values from the array.");
        System.out.println("sortAscending     :Sorts the array in ascending order.");
        System.out.println("sortDescending    :Sorts the array in descending order.");
        System.out.println("evenNumbers       :Returns an array of even numbers.");
        System.out.println("oddNumbers        :Returns an array of odd numbers.");
        System.out.println("rotateLeft <positions>:Rotates the array to the left by a given number of positions.");
        System.out.println("rotateRight <positions>:Rotates the array to the right by a given number of positions.");
        System.out.println("replaceArrayElements <oldVal> <newVal>: Replace all occurrences of an element with another.");
        System.out.println("search <value> : Search for an element in the array.");
        System.out.println("equalArrays <array2>: Check if the current array is equal to another array.");
        System.out.println("  getSubArray a b             - Get subarray from index a to b");
        System.out.println("  splitArray n                - Split array into n parts");
       
        System.out.println("  isPalindromeArray           - Check if array is palindrome");
        System.out.println("  squareElements              - Square each array element");
        System.out.println("  negateElements              - Negate each array element");
        System.out.println("  doubleValues                - Double each array element");
        
        System.out.println("  removeZeros                 - Remove zeros from array");
        System.out.println("  shuffleArray                - Shuffle array elements randomly");
        System.out.println("  bubbleSort                  - Sort array using bubble sort");
        System.out.println("help              :Displays this help information.");
        System.out.println("man <functionName>:Shows detailed manual for the specified function.");
        System.out.println("exit              :Exits the application.");
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════");
       
    }

 //man to help
public static void man(String functionName) {
    switch (functionName) {
        case "findMax" -> showManual("findMax", "Finds the maximum value in the array.", "findMax", "Input: [1, 5, 3]\n\tOutput: 5");
        case "findMin" -> showManual("findMin", "Finds the minimum value in the array.", "findMin", "Input: [1, 5, 3]\n\tOutput: 1");
        case "calculateSum" -> showManual("calculateSum", "Calculates the sum of all elements in the array.", "calculateSum", "Input: [1, 2, 3]\n\tOutput: 6");
        case "calculateAverage" -> showManual("calculateAverage", "Calculates the average of all elements in the array.", "calculateAverage", "Input: [1, 2, 3]\n\tOutput: 2.0");
        case "reverseArray" -> showManual("reverseArray", "Reverses the elements in the array.", "reverseArray", "Input: [1, 2, 3]\n\tOutput: [3, 2, 1]");
        case "isSorted" -> showManual("isSorted", "Checks if the array is sorted in ascending order.", "isSorted", "Input: [1, 2, 3]\n\tOutput: true");
        case "linearSearch" -> showManual("linearSearch", "Performs a linear search to find an element.", "linearSearch", "Input: array=[1,2,3], key=2\n\tOutput: 1");
        case "binarySearch" -> showManual("binarySearch", "Performs a binary search on a sorted array.", "binarySearch", "Input: array=[1,2,3], key=3\n\tOutput: 2");
        case "copyArray" -> showManual("copyArray", "Returns a copy of the array.", "copyArray", "Input: [1,2,3]\n\tOutput: [1,2,3]");
        case "mergeArrays" -> showManual("mergeArrays", "Merges two arrays.", "mergeArrays", "Input: [1,2], [3,4]\n\tOutput: [1,2,3,4]");
        case "insertAt" -> showManual("insertAt", "Inserts a value at the specified index in the array.", "insertAt", "Input: index=0, value=10\n\tOutput: [10]");
        case "deleteAt" -> showManual("deleteAt", "Deletes the element at the specified index.", "deleteAt", "Input: [1,2,3], index=1\n\tOutput: [1,3]");
        case "countOccurrences" -> showManual("countOccurrences", "Counts how many times a value appears.", "countOccurrences", "Input: [1,2,2,3], value=2\n\tOutput: 2");
        case "removeDuplicates" -> showManual("removeDuplicates", "Removes duplicate values from the array.", "removeDuplicates", "Input: [1,2,2,3]\n\tOutput: [1,2,3]");
        case "sortAscending" -> showManual("sortAscending", "Sorts the array in ascending order.", "sortAscending", "Input: [3,1,2]\n\tOutput: [1,2,3]");
        case "sortDescending" -> showManual("sortDescending", "Sorts the array in descending order.", "sortDescending", "Input: [1,3,2]\n\tOutput: [3,2,1]");
        case "evenNumbers" -> showManual("evenNumbers", "Returns all even numbers in the array.", "evenNumbers", "Input: [1,2,3,4]\n\tOutput: [2,4]");
        case "oddNumbers" -> showManual("oddNumbers", "Returns all odd numbers in the array.", "oddNumbers", "Input: [1,2,3,4]\n\tOutput: [1,3]");
        case "rotateLeft" -> showManual("rotateLeft", "Rotates the array to the left by one position.", "rotateLeft", "Input: [1,2,3,4]\n\tOutput: [2,3,4,1]");
        case "rotateRight" -> showManual("rotateRight", "Rotates the array to the right by one position.", "rotateRight", "Input: [1,2,3,4]\n\tOutput: [4,1,2,3]");
        case "replaceArrayElements" ->showManual("replaceArrayElements", "Replaces all occurrences of a value with a new value in the array.", "replaceArrayElements <oldValue> <newValue>", "Input: [1, 2, 2, 3], replace 2 with 99\n\tOutput: [1, 99, 99, 3]");
        case "search" ->showManual("search", "Searches for a specific value in the array and returns its index.", "search <value>", "Input: [5, 10, 15], search 10\n\tOutput: Index 1");
        case "equalArrays" -> showManual("equalArrays", "Checks whether the current array and another array are equal.", "equalArrays <comma-separated-values>", "Input: [1,2,3], equalArrays 1,2,3\n\tOutput: true");
        case "getSubArray" -> showManual("getSubArray", "Returns a subarray from the start index to the end index.", "getSubArray 1 3", "Input: [1, 2, 3, 4, 5], 1 to 3\n\tOutput: [2, 3, 4]");
        case "splitArray" -> showManual("splitArray", "Splits the array into the specified number of parts.", "splitArray 2", "Input: [1, 2, 3, 4], parts = 2\n\tOutput: [1, 2] [3, 4]");
    
        case "isPalindromeArray" -> showManual("isPalindromeArray", "Checks if the array reads the same backward.", "isPalindromeArray", "Input: [1, 2, 1]\n\tOutput: true");
        case "squareElements" -> showManual("squareElements", "Squares each element of the array.", "squareElements", "Input: [1, 2, 3]\n\tOutput: [1, 4, 9]");
        case "negateElements" -> showManual("negateElements", "Negates each element of the array.", "negateElements", "Input: [1, -2, 3]\n\tOutput: [-1, 2, -3]");
        case "doubleValues" -> showManual("doubleValues", "Doubles each element of the array.", "doubleValues", "Input: [1, 2, 3]\n\tOutput: [2, 4, 6]");
        
        case "removeZeros" -> showManual("removeZeros", "Removes all zeros from the array.", "removeZeros", "Input: [0, 1, 0, 2]\n\tOutput: [1, 2]");
        case "shuffleArray" -> showManual("shuffleArray", "Randomly shuffles the array.", "shuffleArray", "Input: [1, 2, 3]\n\tOutput: [2, 1, 3] (example)");
        case "bubbleSort" -> showManual("bubbleSort", "Sorts the array using the bubble sort algorithm.", "bubbleSort", "Input: [3, 1, 2]\n\tOutput: [1, 2, 3]");
        default -> System.out.println("Function not found in manual.");
    }
}

    private static void showManual(String functionName, String description, String usage, String example) {
        System.out.printf("""
    ╔════════════════════════════════════════════════════════════════════════════════════════════════════╗
    ║ Function: %-90s                  ║
    ╠════════════════════════════════════════════════════════════════════════════════════════════════════╣
    ║ Description: %-85s║
    ║                                                                                                    ║
    ║ Usage: %-95s ║
    ║                                                                                                    ║
    ║ Example: %-93s ║  
    ╚════════════════════════════════════════════════════════════════════════════════════════════════════╝
        """, functionName, description, usage, example);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("     Welcome to Array Operations App!");
        System.out.println("==========================================");
        System.out.println("This app allows you to perform various array operations.");
        System.out.println("Here are the available commands:");
        System.out.println("  help                - Show available commands");
        System.out.println("  man <functionName>  - Show manual for a specific function");
        System.out.println("  set x,y,z           - Set the array elements");
        System.out.println("  print               - Display current array");
        System.out.println("  exit                - Exit the application");
        System.out.println("Type 'help' to see all available operations.");
        System.out.println("Note: You must set the array before performing operations.\n");
    
        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().trim();
    
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else if (input.equalsIgnoreCase("help")) {
                Array.help();
            } else if (input.startsWith("man")) {
                String[] parts = input.split(" ", 2);
                if (parts.length == 2) Array.man(parts[1]);
                else System.out.println("Usage: man <functionName>");
            } else if (input.startsWith("set")) {
                try {
                    String[] parts = input.substring(3).split(",");
                    Array.array = Arrays.stream(parts).map(String::trim).mapToInt(Integer::parseInt).toArray();
                    System.out.println("Array has been set: " + Arrays.toString(Array.array));
                } catch (Exception e) {
                    System.out.println("Invalid format! Use: set 1,2,3");
                }
            }
            else if (input.startsWith("mergeArrays")) {
                try {
                    String[] parts = input.split(" ", 2);
                    if (parts.length < 2 || parts[1].isEmpty()) {
                        System.out.println("Usage: mergeArrays 4,5,6");
                        continue;
                    }
                    int[] otherArray = Arrays.stream(parts[1].split(","))
                                             .map(String::trim)
                                             .mapToInt(Integer::parseInt)
                                             .toArray();
                    Array.mergeArrays(otherArray);
                    System.out.println("Merged array: " + Arrays.toString(Array.array));
                } catch (Exception e) {
                    System.out.println("Invalid format! Use: mergeArrays 4,5,6");
                }
            
            }
            else if (Array.array.length == 0) {
                System.out.println("Array not set! Please use the 'set' command to define the array.");
            } else if (input.equals("print")) {
                System.out.println(Arrays.toString(Array.array));
            } else if (input.equals("findMax")) {
                System.out.println(Array.findMax());
            } else if (input.equals("findMin")) {
                System.out.println(Array.findMin());
            } else if (input.equals("calculateSum")) {
                System.out.println(Array.calculateSum());
            } else if (input.equals("calculateAverage")) {
                System.out.println(Array.calculateAverage());
            } else if (input.equals("reverseArray")) {
                Array.reverseArray();
                System.out.println("Array reversed.");
            } else if (input.equals("isSorted")) {
                System.out.println(Array.isSorted());
            } else if (input.startsWith("linearSearch")) {
                int val = Integer.parseInt(input.split(" ")[1]);
                System.out.println(Array.linearSearch(val));
            } else if (input.startsWith("binarySearch")) {
                int val = Integer.parseInt(input.split(" ")[1]);
                System.out.println(Array.binarySearch(val));
            } else if (input.equals("copyArray")) {
                System.out.println(Arrays.toString(Array.copyArray()));
            } else if (input.startsWith("insertAt")) {
                String[] p = input.split(" ");
                Array.insertAt(Integer.parseInt(p[1]), Integer.parseInt(p[2]));
                System.out.println("Element inserted.");
            } else if (input.startsWith("deleteAt")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                Array.deleteAt(index);
                System.out.println("Element deleted.");
            } else if (input.startsWith("countOccurrences")) {
                int val = Integer.parseInt(input.split(" ")[1]);
                System.out.println(Array.countOccurrences(val));
            } else if (input.equals("removeDuplicates")) {
                Array.removeDuplicates();
                System.out.println("Duplicates removed.");
            } else if (input.equals("sortAscending")) {
                Array.sortAscending();
                System.out.println("Array sorted ascending.");
            } else if (input.equals("sortDescending")) {
                Array.sortDescending();
                System.out.println("Array sorted descending.");
            } else if (input.equals("evenNumbers")) {
                System.out.println(Arrays.toString(Array.evenNumbers()));
            } else if (input.equals("oddNumbers")) {
                System.out.println(Arrays.toString(Array.oddNumbers()));
            }else if (input.startsWith("rotateLeft")) {
                try {
                    String[] parts = input.split(" ");
                    if (parts.length < 2) {
                        System.out.println("Usage: rotateLeft <positions>");
                    } else {
                        int positions = Integer.parseInt(parts[1].trim());
                        Array.rotateLeft(positions);
                        System.out.println("Array after left rotation: " + Arrays.toString(Array.array));
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input! Use: rotateLeft 2");
                }
            }
            else if (input.startsWith("rotateRight")) {
                try {
                    String[] parts = input.split(" ");
                    if (parts.length < 2) {
                        System.out.println("Usage: rotateRight <positions>");
                    } else {
                        int positions = Integer.parseInt(parts[1].trim());
                        Array.rotateRight(positions);
                        System.out.println("Array after right rotation: " + Arrays.toString(Array.array));
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input! Use: rotateRight 2");
                }
            }
            else if (input.startsWith("replaceArrayElements")) {
                try {
                    String[] parts = input.split(" ");
                    if (parts.length != 3) {
                        System.out.println("Usage: replaceArrayElements <oldVal> <newVal>");
                    } else {
                        int oldVal = Integer.parseInt(parts[1].trim());
                        int newVal = Integer.parseInt(parts[2].trim());
                        Array.replaceArrayElements(oldVal, newVal);
                        System.out.println("Updated Array: " + Arrays.toString(Array.array));
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Use: replaceArrayElements 2 99");
                }
            }
            
            else if (input.startsWith("search")) {
                try {
                    String[] parts = input.split(" ");
                    if (parts.length != 2) {
                        System.out.println("Usage: search <value>");
                    } else {
                        int value = Integer.parseInt(parts[1].trim());
                        int index = Array.search(value);
                        if (index == -1)
                            System.out.println("Element not found.");
                        else
                            System.out.println("Element found at index: " + index);
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Use: search 5");
                }
            }
            
            else if (input.startsWith("equalArrays")) {
                try {
                    String[] parts = input.split(" ");
                    if (parts.length != 2) {
                        System.out.println("Usage: equalArrays <comma-separated-values>");
                    } else {
                        String[] strVals = parts[1].split(",");
                        int[] otherArray = new int[strVals.length];
                        for (int i = 0; i < strVals.length; i++) {
                            otherArray[i] = Integer.parseInt(strVals[i].trim());
                        }
                        boolean isEqual = Array.equalArrays(otherArray);
                        System.out.println("Arrays are " + (isEqual ? "equal." : "not equal."));
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Use: equalArrays 1,2,3");
                }
            }
            else if (input.startsWith("splitArray")) {
                try {
                    int parts = Integer.parseInt(input.split(" ")[1]);
                    int[][] result = splitArray(array, parts);
                    for (int[] part : result) {
                        System.out.println(Arrays.toString(part));
                    }
                } catch (Exception e) {
                    System.out.println("Usage: splitArray <parts>");
                }
            
            } else if (input.equals("isPalindromeArray")) {
                System.out.println("Is palindrome: " + isPalindromeArray(array));
            } else if (input.equals("squareElements")) {
                System.out.println("Squared: " + Arrays.toString(squareElements(array)));
            } else if (input.equals("negateElements")) {
                System.out.println("Negated: " + Arrays.toString(negateElements(array)));
            } else if (input.equals("doubleValues")) {
                System.out.println("Doubled: " + Arrays.toString(doubleValues(array)));
            
            } else if (input.equals("removeZeros")) {
                System.out.println("Without zeros: " + Arrays.toString(removeZeros(array)));
            } else if (input.equals("shuffleArray")) {
                shuffleArray(array);
                System.out.println("Shuffled: " + Arrays.toString(array));
            } else if (input.equals("bubbleSort")) {
                System.out.println("Bubble sorted: " + Arrays.toString(bubbleSort(array)));
            } 
            
          else {
                System.out.println("Unknown command. Type 'help' to see available functions.");
            }
        }
    
        scanner.close();
    }
    
}
