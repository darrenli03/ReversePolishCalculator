import java.util.ArrayList;

public class ScrambleWord {

    private static String word = "arabian";

    public static void main(String[] args) {

        System.out.println(scrambleWord(word));
    }

    public static String scrambleWord(String word) {
        ArrayList<Character> chars = new ArrayList<Character>();
        char[] array = word.toCharArray();

        for (char c : array) {
            chars.add(c);
        }

        for (int i = 0; i < word.length() - 1; i++) {
            char letter = word.charAt(i);
            char nextLetter = word.charAt(i+1);
            char letterA = 'a';

            if (letter == letterA && nextLetter != letterA){
                chars.remove(i + 1);
                chars.add(i, nextLetter);
                i++;

            }

        }

        return String.valueOf(chars);
    }
}
