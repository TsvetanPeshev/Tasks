import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SherlockAndTheValidString {
    private static final BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));

    static String isValid(String s) {
        int limitToRemove = 1;
        int charCounter = 0;
        char currentChar;
        int referenceNumber;
        int indexCounter = -1;
        ArrayList<Integer> numbers = new ArrayList<>();
        char[] sortedString = s.toCharArray();
        Arrays.sort(sortedString);
        char prevChar = sortedString[0];

        for (int i = 0; i < sortedString.length; i++) {
            currentChar = sortedString[i];
            if (currentChar == prevChar) {
                charCounter++;
            } else {
                numbers.add(charCounter);
                charCounter = 1;
            }
            if (i == sortedString.length - 1) {
                numbers.add(charCounter);
            }
            prevChar = currentChar;
        }

        Collections.sort(numbers);

//        for (int n : numbers) {
//            System.out.printf("%d, ", n);
//        }

        referenceNumber = numbers.get(0);

        for (int n : numbers) {
            indexCounter++;
            if (((n - referenceNumber) > 1 && indexCounter > 1)|| limitToRemove < 0) {
                limitToRemove -= (n - referenceNumber);
                break;
            }
            if (n != referenceNumber) {
                if(indexCounter == 1) {
                    referenceNumber = numbers.get(indexCounter);
                }
                limitToRemove--;
            }
        }

        return limitToRemove >= 0 ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
        String s = bufferedreader.readLine().toLowerCase();

        String result = isValid(s);

        System.out.printf("%s", result);

        bufferedreader.close();
    }
}
