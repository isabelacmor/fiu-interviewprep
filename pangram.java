import java.util.Arrays;

public class pangram {
    
    public static void main(String[] args) {
        String inputDouble = "aaa";
        String inputDouble2 = "aabb";

        System.out.println(hasExactlyTwo(inputDouble) ? "YES" : "NO");
        System.out.println(hasExactlyTwo(inputDouble2) ? "YES" : "NO");

        System.out.println(hasExactlyTwo2(inputDouble) ? "YES" : "NO");
        System.out.println(hasExactlyTwo2(inputDouble2) ? "YES" : "NO");
    }

    public static boolean hasExactlyTwo(String input) {
        input = input.toLowerCase();
        int[] alphabet = new int[26];

        for (int i = 0; i < input.length(); i++) {
            alphabet[input.charAt(i) - 'a']++;
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0 && alphabet[i] != 2) return false;
        }
        return true;
    }

    public static boolean hasExactlyTwo2(String input) {
        for (int i = 0; i < input.length(); i++) {
            int count = 0;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    count++;
                    if (count > 2) {
                        return false; // more than twice
                    } 
                }
            }
            if (count == 1) {
                return false; // character occurs only once
            }
        }
        return true;
    }
}