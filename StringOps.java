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

        while (string.charAt(j) == 32) {
            if (string.charAt(j+1) != 32) {
                currentChar = string.charAt(j+1);
                if (string.charAt(j+1) >= 'A' && string.charAt(j+1) <= 'Z') {
                currentChar = capToSmall(currentChar);
                }
                newString += currentChar;
                break;
            } else {
                j++;
            }
        }

        // Change all other letters to small letters
        for (int i = j + 2; i < string.length(); i++) {
            currentChar = string.charAt(i);
            if (currentChar != 32) {
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
