import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class TwoStrings {
    private static final BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

    static String twoStrings(String s1, String s2) {
//        for (char ch : s1.toCharArray()) {
//           if(s2.indexOf(ch) != -1){
//               return "YES";
//           }
//        }
//        return "NO";
        Set<String> set1 = new TreeSet<>();
        Set<String> set2 = new TreeSet<>();

        for (char ch : s1.toCharArray()) {
            set1.add(Character.toString(ch));
        }
        for (char ch : s2.toCharArray()) {
            set2.add(Character.toString(ch));
        }

        set1.retainAll(set2);

        if(set1.isEmpty()){
            return "NO";
        }else{
            return "YES";
        }
    }

    public static void main(String[] args) throws IOException {
        int p = Integer.parseInt(bufferReader.readLine());

        for (int i = 0; i < p; i++) {
            String s1 = bufferReader.readLine();
            String s2 = bufferReader.readLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
        }
        bufferReader.close();
    }
}