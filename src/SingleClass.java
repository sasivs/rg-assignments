public class SingleClass {
    private static SingleClass instance;
    private SingleClass() {}
    public static SingleClass getInstance() {
        if (instance == null) {
            instance = new SingleClass();
        }
        return instance;
    }
    public void displayMessage(){
        System.out.println("Hello World~! This is a single class");
    }
    public static void main(String[] args) {
        SingleClass example1 = SingleClass.getInstance();
        SingleClass example2 = SingleClass.getInstance();

        example1.displayMessage();

        System.out.println("Hashcodes of instances example1 and example2");
        System.out.println("Example1:" + example1.hashCode());
        System.out.println("Example2:" + example2.hashCode());
    }
}
