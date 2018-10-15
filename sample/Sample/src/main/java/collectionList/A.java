package collectionList;

public class A implements Int1,Int2{
    public void get() {
        System.out.println("sdj");
    }
    public static void main(String[] args) {
     A a=new A();
     a.get();
    }

    public A() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
