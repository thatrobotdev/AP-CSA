import java.util.ArrayList;

public class AList {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();

        for(int i = 0; i < 20; i++) {
            list.add(Math.random());
        }

        System.out.println(list);

        for(int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) * -1.0);
        }

        double min = list.get(0);
        for(Double val: list) {
            if(val < min) {
                min = val;
            }
        }
        System.out.println(min);

        for(int i = 0; i < list.size(); i += 2) {
            list.add(i, 0.0);
        }

        System.out.println(list);

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) > -0.5) {
                list.remove(i);
                i--;
            }
        }

        System.out.println(list);

    }
}
