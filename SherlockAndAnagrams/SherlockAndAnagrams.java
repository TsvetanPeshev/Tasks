import java.io.PrintStream;
import java.util.*;

public class SherlockAndAnagrams {

    private static final PrintStream out = System.out;

    static int sherlockAnagrams(String s) {
        int pairsCounter = 0;
        Map<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char[] elementAsArray = s.substring(i, j + 1).toCharArray();

                Arrays.sort(elementAsArray);

                String key = new String(elementAsArray);

                if(hashMap.containsKey(key)){
                    hashMap.put(key, hashMap.get(key) + 1);
                }else{
                    hashMap.put(key, 1);
                }
            }
        }

        for (String k : hashMap.keySet()) {
//            if(hashMap.get(k) > 1 && (hashMap.get(k) % 2 == 0)){
//                pairsCounter += hashMap.get(k) / 2;
//            }
            int temp = hashMap.get(k);
            pairsCounter += (temp * (temp - 1)) / 2;
        }
        return pairsCounter;
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        in.skip("(\r\n|[\n\r\u2828\u2829\u0085])?");

        for (int i = 0; i < q; i++) {
            String s = in.nextLine().replace(" ", "").toLowerCase();

            int result = sherlockAnagrams(s);
            out.println(result);
        }
        in.close();
    }
}
