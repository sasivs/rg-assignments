public class StaticDefaultExample implements NewInterfaceExample {
    @Override
    public int doubleNum(int a) {
        return 2*a;
    }

    public static void main(String[] args) {
        StaticDefaultExample obj = new StaticDefaultExample();
        System.out.println(obj.doubleNum(5));
        obj.displayMessage();
        NewInterfaceExample.message();
    }
}
