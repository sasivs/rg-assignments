public class EncapsulatedClass {
    private int field1;
    private String field2;

    public void setField1(int field1) {
        this.field1 = field1;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public int getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public static void main(String[] args) {
        EncapsulatedClass c = new EncapsulatedClass();
        c.setField1(1);
        System.out.println(c.getField1());
        c.setField2("Hello World~!");
        System.out.println(c.getField2());
    }
}
