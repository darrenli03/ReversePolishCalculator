public class CommonTwo {
    public static void main(String[] args) {
        CommonTwo object = new CommonTwo();
        String[] strArray = new String[] {"a", "b", "c", "c", "d"};
        String[] strArray1 = new String[] {"a", "b", "b", "c", "d", "d"};
        System.out.println(object.commonTwo(strArray, strArray1));
    }

    public int commonTwo(String[] a, String[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++){
            if(i >= 1 && a[i].equals(a[i-1])){
                System.out.println("a is repeat at index " + i);

            } else {
                for (int j = 0; j < b.length; j++){
                    System.out.println("a is at index " + i  + ", b is at index " + j);

                    if(j >= 1 && b[j].equals(b[j-1])){
                        System.out.println("b is repeat at index " + j);

                    } else {
                        if (a[i].equals(b[j])){
                            count++;
                            System.out.println("counted");

                        }
                    }
                }
            }
        }

        return count;
    }
}
