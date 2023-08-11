import java.util.ArrayList;
import java.util.List;

public class ScrambleWordNew {

    public static String scrambleWord(String word) {
        String scrambledWord = "";

        for (int i = 0; i < word.length() - 1; i++) {
            char letter = word.charAt(i);
            char nextLetter = word.charAt(i + 1);

            if (letter == 'A' && nextLetter != 'A') {
                scrambledWord += nextLetter;
                scrambledWord += letter;
                i++;
            } else {
                scrambledWord += letter;
            }
        }
        scrambledWord += word.charAt(word.length() - 1);

        System.out.println(scrambledWord);
        return scrambledWord;
    }

//    public static String scrambleWord(String word){
//        int current = 0;
//        String result="";
//        while (current < word.length()-1){
//            if (word.substring(current,current+1).equals("A") &&
//                    !word.substring(current+1,current+2).equals("A")){
//                result += word.substring(current+1,current+2);
//                result += "A";
//                current += 2;
//            }
//            else {
//                result += word.substring(current,current+1);
//                current++;
//            }
//        }
//        if (current < word.length()){
//            result += word.substring(current);
//        }
//        return result;
//    }

    public static void scrambleOrRemove(List<String> wordList){
        for(int i = 0; i < wordList.size(); i++){
            String currentWord = wordList.get(i);
            String scrambledWord = scrambleWord(currentWord);

            if(scrambledWord.equals(currentWord)){
                wordList.remove(currentWord);
                i--;
            } else {
                wordList.remove(currentWord);
                wordList.add(i, scrambledWord);
            }
        }
    }


    public static void main(String[] args) {
        String word = "ALOPOECIA";
        List<String> words = new ArrayList<>();
        words.add("ALOPOECIA");
        words.add("TREE");
        words.add("BANANA");
        words.add("ARABIAN");
        System.out.println(words);
        scrambleOrRemove(words);
        System.out.println(words);
    }
}
