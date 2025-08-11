import java.util.Scanner;

public class StringOperationsApp {

    // Function 1: Length
    public int length(String str) {
        int length = 0;
        while (true) {
            try {
                str.charAt(length);
                length++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return length;
    }

    // Function 2: IsEmpty
    public boolean isEmpty(String str) {
        return str.length() == 0;
    }

    // Function 3: CharAt
    public char charAt(String str, int index) {
        if (index < 0 || index >= str.length()) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return str.charAt(index);
    }

    // Function 4: Substring
    public String substring(String str, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > str.length() || startIndex > endIndex) {
            throw new StringIndexOutOfBoundsException("Invalid start or end index");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // Function 5: Concatenation
    public String concat(String str1, String str2) {
        char[] result = new char[str1.length() + str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            result[i] = str1.charAt(i);
        }
        for (int i = 0; i < str2.length(); i++) {
            result[str1.length() + i] = str2.charAt(i);
        }
        return new String(result);
    }

    // Function 6: Replace
    public String replace(String str, char oldChar, char newChar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == oldChar) {
                sb.append(newChar);
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    // Function 7: ToLowerCase
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c + ('a' - 'A')));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Function 8: Trim
    public String trim(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end && (str.charAt(start) == ' ' || str.charAt(start) == '\n' || str.charAt(start) == '\t')) {
            start++;
        }

        while (end >= start && (str.charAt(end) == ' ' || str.charAt(end) == '\n' || str.charAt(end) == '\t')) {
            end--;
        }

        return str.substring(start, end + 1);
    }

    // Function 9: Contains
    public boolean contains(String str, String substr) {
        for (int i = 0; i <= str.length() - substr.length(); i++) {
            boolean match = true;
            for (int j = 0; j < substr.length(); j++) {
                if (str.charAt(i + j) != substr.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    // Function 10: IndexOf
    public int indexOf(String str, char ch) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }

    // Function 11: Split
    public String[] split(String str, String delimiter) {
        int count = 1;
        for (int i = 0; i < str.length() - delimiter.length() + 1; i++) {
            if (str.substring(i, i + delimiter.length()).equals(delimiter)) {
                count++;
                i += delimiter.length() - 1;
            }
        }

        String[] result = new String[count];
        int index = 0;
        int lastIndex = 0;
        for (int i = 0; i < str.length() - delimiter.length() + 1; i++) {
            if (str.substring(i, i + delimiter.length()).equals(delimiter)) {
                result[index++] = str.substring(lastIndex, i);
                lastIndex = i + delimiter.length();
                i += delimiter.length() - 1;
            }
        }
        result[index] = str.substring(lastIndex);
        return result;
    }

    // Function 12: Matches
    public boolean matches(String str, String regex) {
        return str.contains(regex);
    }

    // Function 13: toUpperCase
    public String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append((char) (c - ('a' - 'A')));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Function 14: equals
    public boolean equals(String str1, String str2) {
        return str1.equals(str2);
    }

    // Function 15: startsWith
    public boolean startsWith(String str, String prefix) {
        return str.startsWith(prefix);
    }

    // Function 16: endsWith
    public boolean endsWith(String str, String suffix) {
        return str.endsWith(suffix);
    }

    // Function 17: replaceAll
    public String replaceAll(String str, String oldSubStr, String newSubStr) {
        return str.replaceAll(oldSubStr, newSubStr);
    }

    // Function 18: valueOf
    public String valueOf(int num) {
        return String.valueOf(num);
    }

    // Function 19: join
    public String join(String delimiter, String[] strings) {
        return String.join(delimiter, strings);
    }

    // Help function to explain the role of each function
    public void help() {
        System.out.println("\nAvailable functions:");
        System.out.println("1. length   : Returns the length of the string.");
        System.out.println("2. isEmpty  : Checks if the string is empty.");
        System.out.println("3. charAt   : Returns the character at the specified index.");
        System.out.println("4. substring: Returns a part of the string between the specified indices.");
        System.out.println("5. concat   : Concatenates two strings.");
        System.out.println("6. replace  : Replaces all occurrences of a character with another character.");
        System.out.println("7. toLowerCase: Converts the string to lowercase.");
        System.out.println("8. trim     : Removes whitespace from the beginning and end of the string.");
        System.out.println("9. contains : Checks if the string contains the specified substring.");
        System.out.println("10. indexOf : Returns the index of the first occurrence of the specified character.");
        System.out.println("11. split   : Splits the string based on a delimiter.");
        System.out.println("12. matches : Checks if the string matches the specified regex.");
        System.out.println("13. toUpperCase: Converts all characters of the string to uppercase.");
        System.out.println("14. equals  : Compares two strings and returns true if they are equal.");
        System.out.println("15. startsWith: Checks if the string starts with a specified prefix.");
        System.out.println("16. endsWith: Checks if the string ends with a specified suffix.");
        System.out.println("17. replaceAll: Replaces all occurrences of a substring in the string with another substring.");
        System.out.println("18. valueOf : Converts the specified integer to a string.");
        System.out.println("19. join    : Joins an array of strings into a single string with the specified delimiter.");

    }

    public void man(String name) {
        System.out.println("\n### DEMO: How to Use the Functions ###\n");
        if (name == null)
            return;

        if ("length".equals(name)) {
            // Example for 'length'
            System.out.println("\n1. length: Returns the length of the string.");
            System.out.println("   Input: \"hello\"");
            System.out.println("   Code: length(\"hello\")");
            System.out.println("   Output: " + length("hello"));
            System.out.println("   Explanation: This function returns the number of characters in the string.");
            System.out.println("   Example: length(\"hello\") returns 5 because \"hello\" contains 5 characters.");
        } else if ("isEmpty".equals(name)) {
            // Example for 'isEmpty'
            System.out.println("\n2. isEmpty: Checks if the string is empty.");
            System.out.println("   Input: \"hello\"");
            System.out.println("   Code: isEmpty(\"hello\")");
            System.out.println("   Output: " + isEmpty("hello"));
            System.out.println("   Explanation: This function checks if the string has a length of 0.");
            System.out.println("   Example: isEmpty(\"hello\") returns false because \"hello\" is not empty.");
        } else if ("charAt".equals(name)) {
            // Example for 'charAt'
            System.out.println("\n3. charAt: Returns the character at the specified index.");
            System.out.println("   Input: \"hello\" with index 1");
            System.out.println("   Code: charAt(\"hello\", 1)");
            System.out.println("   Output: " + charAt("hello", 1));
            System.out.println(
                    "   Explanation: This function returns the character at the specified index in the string.");
            System.out.println("   Example: charAt(\"hello\", 1) returns 'e' because it's the character at index 1.");
        } else if ("subString".equals(name)) {
            // Example for 'substring'
            System.out.println("\n4. substring: Returns a part of the string between the specified indices.");
            System.out.println("   Input: \"hello\" with start index 1 and end index 4");
            System.out.println("   Code: substring(\"hello\", 1, 4)");
            System.out.println("   Output: " + substring("hello", 1, 4));
            System.out.println("   Explanation: This function extracts a substring from the original string.");
            System.out.println("   Example: substring(\"hello\", 1, 4) returns \"ell\".");
        } else if ("concat".equals(name)) {
            // Example for 'concat'
            System.out.println("\n5. concat: Concatenates two strings.");
            System.out.println("   Input: \"hello\" and \" world\"");
            System.out.println("   Code: concat(\"hello\", \" world\")");
            System.out.println("   Output: " + concat("hello", " world"));
            System.out.println("   Explanation: This function concatenates two strings together.");
            System.out.println("   Example: concat(\"hello\", \" world\") returns \"hello world\".");
        } else if ("replace".equals(name)) {
            // Example for 'replace'
            System.out.println("\n6. replace: Replaces all occurrences of a character with another character.");
            System.out.println("   Input: \"hello\" with old char 'e' and new char 'a'");
            System.out.println("   Code: replace(\"hello\", 'e', 'a')");
            System.out.println("   Output: " + replace("hello", 'e', 'a'));
            System.out.println("   Explanation: This function replaces all occurrences of a character in a string.");
            System.out.println("   Example: replace(\"hello\", 'e', 'a') returns \"hallo\".");
        } else if ("toLowerCase".equals(name)) {
            // Example for 'toLowerCase'
            System.out.println("\n7. toLowerCase: Converts the string to lowercase.");
            System.out.println("   Input: \"HELLO\"");
            System.out.println("   Code: toLowerCase(\"HELLO\")");
            System.out.println("   Output: " + toLowerCase("HELLO"));
            System.out.println("   Explanation: This function converts all characters in the string to lowercase.");
            System.out.println("   Example: toLowerCase(\"HELLO\") returns \"hello\".");
        } else if ("trim".equals(name)) {
            // Example for 'trim'
            System.out.println("\n8. trim: Removes whitespace from the beginning and end of the string.");
            System.out.println("   Input: \"  hello  \"");
            System.out.println("   Code: trim(\"  hello  \")");
            System.out.println("   Output: " + trim("  hello  "));
            System.out.println("   Explanation: This function removes leading and trailing spaces from the string.");
            System.out.println("   Example: trim(\"  hello  \") returns \"hello\".");
        } else if ("contains".equals(name)) {
            // Example for 'contains'
            System.out.println("\n9. contains: Checks if the string contains the specified substring.");
            System.out.println("   Input: \"hello\" with substring \"ell\"");
            System.out.println("   Code: contains(\"hello\", \"ell\")");
            System.out.println("   Output: " + contains("hello", "ell"));
            System.out.println("   Explanation: This function checks if the string contains the given substring.");
            System.out.println(
                    "   Example: contains(\"hello\", \"ell\") returns true because \"hello\" contains \"ell\".");
        } else if ("indexOf".equals(name)) {
            // Example for 'indexOf'
            System.out.println("\n10. indexOf: Returns the index of the first occurrence of the specified character.");
            System.out.println("   Input: \"hello\" with character 'e'");
            System.out.println("   Code: indexOf(\"hello\", 'e')");
            System.out.println("   Output: " + indexOf("hello", 'e'));
            System.out.println(
                    "   Explanation: This function returns the index of the first occurrence of a character in the string.");
            System.out.println("   Example: indexOf(\"hello\", 'e') returns 1.");
        } else if ("split".equals(name)) {
            // Example for 'split'
            System.out.println("\n11. split: Splits the string into an array of substrings based on a delimiter.");
            System.out.println("   Input: \"apple,banana,orange\" with delimiter \",\"");
            System.out.println("   Code: split(\"apple,banana,orange\", \",\")");
            System.out.println("   Output: ");
            String[] result = split("apple,banana,orange", ",");
            for (String part : result) {
                System.out.print(part + " ");
            }
            System.out.println();
            System.out.println(
                    "   Explanation: This function splits the string into an array using the provided delimiter.");
            System.out.println(
                    "   Example: split(\"apple,banana,orange\", \",\") returns [\"apple\", \"banana\", \"orange\"].");
        }

        else if ("matches".equals(name)) {
            // Example for 'matches'
            System.out.println("\n12. matches: Checks if the string matches the given regular expression.");
            System.out.println("   Input: \"hello\" with regex \".*lo$\"");
            System.out.println("   Code: matches(\"hello\", \".*lo$\")");
            System.out.println("   Output: " + matches("hello", ".*lo$"));
            System.out.println("   Explanation: This function checks if the string matches the given regex.");
            System.out.println(
                    "   Example: matches(\"hello\", \".*lo$\") returns true because \"hello\" ends with \"lo\".");
        } else if ("toUpperCase".equals(name)) {
            // Example for 'toUpperCase'
            System.out.println("13. toUpperCase: Converts the string to uppercase.");
            System.out.println("   Input: \"hello\"");
            System.out.println("   Code: toUpperCase(\"hello\")");
            System.out.println("   Output: " + toUpperCase("hello"));
            System.out.println(
                    "   Explanation: This function takes a string and converts all characters to uppercase letters.");
            System.out.println("   Example: toUpperCase(\"hello\") returns \"HELLO\"");
        }

        else if ("equals".equals(name)) {
            // Example for 'equals'
            System.out.println("\n14. equals: Compares two strings for equality.");
            System.out.println("   Input: \"hello\" and \"hello\"");
            System.out.println("   Code: equals(\"hello\", \"hello\")");
            System.out.println("   Output: " + equals("hello", "hello"));
            System.out.println(
                    "   Explanation: This function compares two strings to check if they are exactly the same.");
            System.out.println(
                    "   Example: equals(\"hello\", \"hello\") returns true because both strings are identical.");
        } else if ("startsWith".equals(name)) {
            // Example for 'startsWith'
            System.out.println("\n15. startsWith: Checks if the string starts with a specified prefix.");
            System.out.println("   Input: \"hello\" with prefix \"he\"");
            System.out.println("   Code: startsWith(\"hello\", \"he\")");
            System.out.println("   Output: " + startsWith("hello", "he"));
            System.out.println("   Explanation: This function checks if the string starts with the specified prefix.");
            System.out.println(
                    "   Example: startsWith(\"hello\", \"he\") returns true because \"hello\" starts with \"he\".");
        } else if ("endsWith".equals(name)) {
            // Example for 'endsWith'
            System.out.println("\n16. endsWith: Checks if the string ends with a specified suffix.");
            System.out.println("   Input: \"hello\" with suffix \"lo\"");
            System.out.println("   Code: endsWith(\"hello\", \"lo\")");
            System.out.println("   Output: " + endsWith("hello", "lo"));
            System.out.println("   Explanation: This function checks if the string ends with the specified suffix.");
            System.out.println(
                    "   Example: endsWith(\"hello\", \"lo\") returns true because \"hello\" ends with \"lo\".");
        } else if ("replaceAll".equals(name)) {
            // Example for 'replaceAll'
            System.out.println("\n17. replaceAll: Replaces all occurrences of a substring with another substring.");
            System.out.println("   Input: \"hello world\" with old substring \"world\" and new substring \"Java\"");
            System.out.println("   Code: replaceAll(\"hello world\", \"world\", \"Java\")");
            System.out.println("   Output: " + replaceAll("hello world", "world", "Java"));
            System.out.println(
                    "   Explanation: This function replaces all occurrences of a given substring with another substring.");
            System.out.println("   Example: replaceAll(\"hello world\", \"world\", \"Java\") returns \"hello Java\".");
        } else if ("valueOf".equals(name)) {
            // Example for 'valueOf'
            System.out.println("\n18. valueOf: Converts a primitive type to a string.");
            System.out.println("   Input: 123");
            System.out.println("   Code: valueOf(123)");
            System.out.println("   Output: " + valueOf(123));
            System.out.println(
                    "   Explanation: This function converts a primitive data type, like an integer, to its string representation.");
            System.out.println("   Example: valueOf(123) returns \"123\".");
        } else if ("join".equals(name)) {
            // Example for 'join'
            System.out.println("\n19. join: Joins an array of strings with a specified delimiter.");
            String[] strings = { "apple", "banana", "orange" };
            System.out.println("   Input: [\"apple\", \"banana\", \"orange\"] with delimiter \",\"");
            System.out.println("   Code: join(\",\", [\"apple\", \"banana\", \"orange\"])");
            System.out.println("   Output: " + join(",", strings));
            System.out.println(
                    "   Explanation: This function joins an array of strings with a given delimiter between them.");
            System.out.println(
                    "   Example: join(\",\", [\"apple\", \"banana\", \"orange\"]) returns \"apple,banana,orange\".");
        }

        else {
            System.out.println("Invalid Calling Function.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringOperationsApp app = new StringOperationsApp(); // Create instance of the class

        while (true) {
            System.out.println("\nEnter the function name you want to call (or 'exit' to quit):"); 
            System.out.println("help ,man,exit");
            String choice = scanner.nextLine().trim(); // Get function name as input

            // Split the input string to handle "man" followed by the function name
            String[] input = choice.split(" ", 2); // Split at the first space into two parts
            String command = input[0]; // The first part is the command (e.g., "man")

            if (choice.equals("exit")) {
                System.out.println("Exiting program.");
                break;
            } else if (choice.equals("help")) {
                app.help(); // Display help information
            } else {
                // Perform action based on function name
                // if ("length".equals(choice)) {
                // System.out.println("Enter the string:");
                // String str1 = scanner.nextLine();
                // System.out.println("Length: " + app.length(str1));
                if ("length".equals(choice)) {
                    System.out.println("Enter the string:");
                    String str = scanner.nextLine();
                    // Logic for length:
                    int length = 0;
                    while (true) {
                        try {
                            str.charAt(length);
                            length++;
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                    System.out.println("Length: " + length);
                } else if ("man".equals(command) && input.length > 1) {

                    app.man(input[1].trim()); // Call 'man' with the argument after "man" in the input
                   } else if ("man".equalsIgnoreCase(command)) {
    if (input.length > 1 && input[1] != null && !input[1].trim().isEmpty()) {
        app.man(input[1].trim()); // Call 'man' with the argument
    } else {
        System.out.println("Usage: man [command]");
    }
 
                } else if ("isEmpty".equals(choice)) {
                    System.out.println("Enter the string:");
                    String str2 = scanner.nextLine();
                    System.out.println("Is Empty: " + app.isEmpty(str2));
                } else if ("charAt".equals(choice)) {
                    System.out.println("Enter the string:");
                    String str3 = scanner.nextLine();
                    System.out.println("Enter index:");
                    int index3 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Character at index " + index3 + ": " + app.charAt(str3, index3));
                } else if ("substring".equals(choice)) {
                    System.out.println("Enter the string:");
                    String str4 = scanner.nextLine();
                    System.out.println("Enter start index:");
                    int start4 = scanner.nextInt();
                    System.out.println("Enter end index:");
                    int end4 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Substring: " + app.substring(str4, start4, end4));
                } else if ("concat".equals(choice)) {
                    System.out.println("Enter first string:");
                    String str5a = scanner.nextLine();
                    System.out.println("Enter second string:");
                    String str5b = scanner.nextLine();
                    System.out.println("Concatenated String: " + app.concat(str5a, str5b));
                } else if ("replace".equals(choice)) {
                    System.out.println("Enter the string:");
                    String str6 = scanner.nextLine();
                    System.out.println("Enter the character to replace:");
                    char oldChar6 = scanner.next().charAt(0);
                    System.out.println("Enter the new character:");
                    char newChar6 = scanner.next().charAt(0);
                    scanner.nextLine(); // Consume newline
                    System.out.println("Replaced String: " + app.replace(str6, oldChar6, newChar6));
                } else if ("toLowerCase".equals(choice)) {
                    System.out.println("Enter the string:");
                    String str7 = scanner.nextLine();
                    System.out.println("Lowercase String: " + app.toLowerCase(str7));
                } else if ("trim".equals(choice)) {
                    System.out.println("Enter the string:");
                    String str8 = scanner.nextLine();
                    System.out.println("Trimmed String: " + app.trim(str8));
                } else if ("contains".equals(choice)) {
                    System.out.println("Enter the string:");
                    String str9 = scanner.nextLine();
                    System.out.println("Enter substring:");
                    String substr9 = scanner.nextLine();
                    System.out.println("Contains substring: " + app.contains(str9, substr9));
                } else if ("indexOf".equals(choice)) {
                    System.out.println("Enter the string:");
                    String str10 = scanner.nextLine();
                    System.out.println("Enter character to find:");
                    char ch10 = scanner.next().charAt(0);
                    scanner.nextLine(); // Consume newline
                    System.out.println("Index of character: " + app.indexOf(str10, ch10));
                } else if ("split".equals(choice)) {
                    System.out.println("Enter the string:");
                    String str11 = scanner.nextLine();
                    System.out.println("Enter delimiter:");
                    String delimiter11 = scanner.nextLine();
                    String[] result11 = app.split(str11, delimiter11);
                    System.out.println("Split parts:");
                    for (String part : result11) {
                        System.out.println(part);
                    }
                } else if ("matches".equals(choice)) {
                    System.out.println("Enter the string:");
                    String str12 = scanner.nextLine();
                    System.out.println("Enter regex:");
                    String regex12 = scanner.nextLine();
                    System.out.println("Matches: " + app.matches(str12, regex12));
                } else {
                    System.out.println("Invalid function name.");
                }
            }
        }
        scanner.close();
    }
}