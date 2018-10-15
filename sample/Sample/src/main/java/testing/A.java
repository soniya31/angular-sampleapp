package testing;

public interface A {
    public void displayGreeting(String msg);
    default void DefaultA(){
        System.out.println("In Default A");
    }
}


