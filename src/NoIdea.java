public class NoIdea {

    int firstInt;
    int secondInt;

    public NoIdea(int x, int y) {
        firstInt = x;
        secondInt = y;
    }

    public static void main(String[] args) {
        NoIdea p1 = new NoIdea(7, 3);
        System.out.println(p1.getProblem());
        System.out.println(p1.getProblem());
        p1.nextProblem();
        System.out.println(p1.getProblem());
    }

    public String getProblem() {

        String str = firstInt + " Times " + secondInt;

        return str;

    }

    public void nextProblem(){
        secondInt++;
    }

}


