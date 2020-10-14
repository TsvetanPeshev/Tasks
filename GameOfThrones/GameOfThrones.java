import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class GameOfThrones {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   static String gameOfThrones(String s) {
       Stack<Character> result = new Stack<>();
       char[] inputAsChars = new char[s.length()];

       for (int i = 0; i < s.length(); i ++){
           inputAsChars[i] = s.charAt(i);
       }

       Arrays.sort(inputAsChars);

       for (char ch : inputAsChars) {
           if(result.size() > 0 && result.peek() == ch){
               result.pop();
           }else{
               result.push(ch);
           }
       }

       return result.size() <= 1? "YES": "NO";
   }
    public static void main(String[] args) throws IOException {
        String s = br.readLine().toLowerCase();
        String result = gameOfThrones(s);

        System.out.println(result);

        br.close();
    }
}
