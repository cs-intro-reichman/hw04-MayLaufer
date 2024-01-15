public class ArrayOps {
    public static void main(String[] args) {
    }
    
    public static int findMissingInt (int [] array) {
        int actualSum = 0;
        int expectedSum = 0;

        // computing the actual sum
        for (int i = 0; i < array.length; i++) {
            actualSum += array[i];
        }

        // computing the expected sum
        for (int i = 1; i <= array.length; i++) {
            expectedSum += i;
        }

        return expectedSum - actualSum;
        
    }

    public static int secondMaxValue(int [] array) {
        int max = array[0];
        int secMax = array[0];
        int index = 0;

        /* for (int i = 1; i < array.length; i++) {
            if (array[i] > secMax) {
                if (array[i] > max) {
                    max = array[i];
                } else {
                    secMax = array[i];
                }
            }

        } */

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (i != index) {
                if (array[i] > secMax) {
                    secMax = array[i];
                }    
            }
        }
        
        return secMax;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            count = 0;
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    count++;
                }
            }
            if (count == 0) {
                break;
            }
        }

        if (count != 0) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isSorted(int [] array) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < array.length; i++) {
           if (array[i] < array[i - 1]) {
            increasing = false;
            break;
           } 
        } 

        if (increasing) {
            return true;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                decreasing = false;
                break;
            }
        }

        return decreasing;
    }

}
