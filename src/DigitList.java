import java.util.ArrayList;

public class DigitList{
    private ArrayList<Integer> digitList;

    public DigitList(int num){
        digitList = new ArrayList<Integer>();

        while(num > 0){
            int rightDigit = num % 10;

            digitList.add(0, rightDigit);
            num /= 10;
        }

        System.out.println(digitList);
    }

    public boolean isStrictlyIncreasing(){
        for(int i=0; i+1<digitList.size(); i++){
            if(digitList.get(i)>=digitList.get(i+1)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new DigitList(1345667).isStrictlyIncreasing());
    }

}
