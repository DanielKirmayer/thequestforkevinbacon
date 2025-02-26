import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        for (int i = 0; i < 1000000; i++) {
            a.add(i+"");
            System.out.println(i);
        }

        System.out.println(a);
    }

}
