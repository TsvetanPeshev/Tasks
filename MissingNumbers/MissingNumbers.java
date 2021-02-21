import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MissingNumbers {
    static int[] missingNumbers(int[] arr, int[] brr) {
        ArrayList<Integer> brrAsList = new ArrayList<>();

        for (int n : brr) {
            brrAsList.add(n);
        }

        for (int i = 0; i < arr.length; i++) {
                brrAsList.remove(Integer.valueOf(arr[i]));

        }

        return brrAsList.stream()
                .distinct()
                .sorted()
                .mapToInt(n -> n).toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        int[] arr = Arrays.stream(input.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int m = Integer.parseInt(input.readLine());

        int[] brr = Arrays.stream(input.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        input.close();
    }
}
