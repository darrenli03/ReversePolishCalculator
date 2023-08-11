import java.util.ArrayList;

public class Delimiters {
    private String openDel;
    private String closeDel;

    public Delimiters(String open, String close) {
        openDel = open;
        closeDel = close;
    }

    public ArrayList getDelimitersList(String[] tokens) {
        ArrayList<String> delimiters = new ArrayList<>();

        for (String s : tokens) {
            if (s.equals(openDel) || s.equals(closeDel)) {
                delimiters.add(s);
            }
        }

        return delimiters;
//        for(int i=0; i < tokens.length; i++){
//
//            for(int j=i; j < tokens.length; j++){
//                String substring = tokens.substring(i, j);
//
//                if(substring.equals(openDel) ||
//                        substring.equals(closeDel)){
//                    delimiters.add(substring);
//
//                }
//            }
//            return delimiters;
//        }
    }

    public boolean isBalanced(ArrayList<String> tokens){
        int open = 0;
        int close = 0;

        for(String s : tokens){
            if(s.equals(openDel)){
                open++;
            } else {
                close++;
            }
        }

        return open == close;

    }
    public static void main(String[] args) {
        String[] tokens = new String[4];

        tokens[0] = "open";
        tokens[1] = "close";
        tokens[2] = "banana";
        tokens[3] = "open";

        Delimiters delim = new Delimiters("open", "close");

        System.out.println(delim.getDelimitersList(tokens));
        System.out.println(delim.isBalanced(delim.getDelimitersList(tokens)));

    }
}
