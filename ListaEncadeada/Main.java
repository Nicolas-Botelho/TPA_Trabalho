import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Comparator<Integer> comparator = Comparator.reverseOrder();

        listaEncad<Integer> l = new listaEncad<Integer>(comparator);

        l.include(1);
        l.include(2);
        l.include(3);
        l.include(-2);
        l.include(10);

        System.out.println(l.toString());
        System.out.println(l.seek(2));
    }


}
