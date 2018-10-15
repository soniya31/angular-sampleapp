package testing;



public class C implements A,B {
    @Override
    public void displayGreeting(String msg) {
        System.out.println(msg);

    }
   public void DefaultA(){

        System.out.println("In Default AC");
    }
    void execute(){}

    public static void main(String[] args) {
        C a =new C();
        a.displayGreeting("Soniya");
        a.DefaultA();
    }
}
