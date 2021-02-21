import java.util.Scanner;

public class FindDigits {
    static int findDigits(int n){
        String stringRepresentationOfTheNumber = Integer.toString(n);
        int counter = 0;

        for (char ch : stringRepresentationOfTheNumber.toCharArray()) {
            if((ch != '0') && (n % (ch - 48) == 0)){
                counter++;
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);
             System.out.printf("%d%n", result);
        }
        in.close();
    }
}
