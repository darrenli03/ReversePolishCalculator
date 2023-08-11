import java.util.ArrayList;
import java.util.Arrays;

public class ProbabilitySim {
    public static void main(String[] args){
        double prob1 = 0.1;
        double prob2 = 0.2;
        int i = 0;
        int prob1Count = 0;
        int prob2Count = 0;
        ArrayList<String> myList = new ArrayList<>(Arrays.asList("potato", "tomato"));

        while( i < 1000000){
            double random = Math.random();

            if(random < prob1){
                prob1Count++;
            }

            if(random < prob2){
                prob2Count++;
            }
            i++;
        }
        System.out.println(prob1Count);
        System.out.println(prob2Count / 2);
    }
}
