import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaExpExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(100,25,1454,45,369,45,22,56,0,58,1);
        list.sort((a, b) -> b - a);
        System.out.println(list);
    }
}
