public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
    }

    public static String capVowelsLowRest (String string) {
        String newString = "";
        String smallVowels = "aeiou";
        String capVowels = "AEIOU";
        int flag = 0;

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (currentChar >= 'a' && currentChar <= 'z') {
                // #feedback - you can use smallVowels.indexOf(currentChar) to know if the current character is a lower case vowel.
                for (int j = 0; j < smallVowels.length(); j++) {
                    if (currentChar == smallVowels.charAt(j)) {
                        currentChar = smallToCap(currentChar);
                    }
                }
            }

            if (currentChar >= 'A' && currentChar <= 'Z') {
                for (int j = 0; j < capVowels.length(); j++) {
                    if (currentChar == capVowels.charAt(j)) {
                        flag++;
                    }
                }
                if (flag == 0) {
                    currentChar = capToSmall(currentChar);
                }
                flag = 0;
            }
            newString += currentChar;
        }
        return newString;
    }

    public static String camelCase (String string) {
        char currentChar = string.charAt(0);
        String newString = "";
        int j = 0;

        // Handle the first letter
        switch (string.charAt(j)) {
            case 32: // #feedback - it is better here to use the actual character than its character representation
                while (string.charAt(j) == 32) {
                    // #feedback - you should check that it is possible to access the j+1 element and you didn't reach the end of the string.
                    if (string.charAt(j+1) != 32) {
                        currentChar = string.charAt(j+1);
                        if (string.charAt(j+1) >= 'A' && string.charAt(j+1) <= 'Z') {
                        currentChar = capToSmall(currentChar);
                        }
                        newString += currentChar;
                        j++;
                        break;
                    } else {
                        // #feedback - also here, you should check that increasing j will still be in the range of the string.
                        j++;
                    }
                }
                    break;
        
            default:
                // #feedback - you have this check throughout the code, consider having helper functions to avoid code repetitions.
                if (string.charAt(j) >= 'A' && string.charAt(j) <= 'Z') {
                    currentChar = capToSmall(currentChar);
                    }
                newString += currentChar;
                break;
        }

        // System.out.println(newString);
    

        // Change all other letters to small letters
        for (int i = j + 1; i < string.length(); i++) {
            currentChar = string.charAt(i);
            if (currentChar != 32) {
                // #feedback - no need to check again that the char is not a space since we already checked it in the previous if.
                if (currentChar != 32 & currentChar >= 'A' && currentChar <= 'Z') {
                    currentChar = capToSmall(currentChar);
                }

                if (string.charAt(i-1) == 32 && currentChar >= 'a' && currentChar <= 'z') {
                    currentChar = smallToCap(currentChar);
                }

                newString += currentChar;
            }

        }

        // Remove space
        /* for (int i = 0; i < string.length(); i++) {
            currentChar = string.charAt(i);
            if (currentChar != 32) {
                newString += currentChar;
            }
        } */

        return newString;
    }

    public static int[] allIndexOf (String string, char chr) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                count++;
            }
        }

        int[] index = new int[count];
        int j = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                index[j] = i;
                j++;
            }
        }

        return index;
    }

    private static char capToSmall (char chr) {
        chr = (char)(chr + 32);
        return chr;
    }

    private static char smallToCap (char chr) {
        chr = (char)(chr - 32);
        return chr;
    }
}
