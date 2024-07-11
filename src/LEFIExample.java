import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LEFIExample {
    public static void LEExample(List<Integer> list){
        list.sort((a, b) -> b - a);
        System.out.println(list);
    }
    public static void FIExample(List<Integer> list){
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(list);
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(100,25,1454,45,369,45,22,56,0,58,1);
        LEExample(list);
        FIExample(list);
    }
}
