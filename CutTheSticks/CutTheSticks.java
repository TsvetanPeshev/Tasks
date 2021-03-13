import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
;

public class CutTheSticks {
    private static final PrintStream out = System.out;

    static int[] cutTheSticks(int[] arr) {
        ArrayList<Integer> resultAsList = new ArrayList<>();

        Arrays.sort(arr);

        resultAsList.add(arr.length);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i - 1]){
                resultAsList.add(arr.length - i);
            }
        }
              return resultAsList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] result = cutTheSticks(arr);

        for (int num : result) {
            out.println(num);
        }

    }
}
