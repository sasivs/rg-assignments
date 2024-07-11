public interface NewInterfaceExample {
    public int doubleNum(int a);

    default void displayMessage(){
        System.out.println("Hello World!!! Default Method");
    }

    static void message(){
        System.out.println("Hello World!!! Static Method");
    }
}
