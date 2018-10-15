package StringTest;

public class StringBasic {
    public static void main(String[] args) {

        System.out.println("abc".compareTo("bcs"));
        int q="ABz".charAt(2);
        System.out.println(q);
        A a= new B();
        a.foo();

        String str1 = "Soniya";
        String str2 = "Soniya";
        char[] arr = {'S', 'o', 'n', 'i', 'y', 'a'};
        String str3 = new String(arr);
        System.out.println();
        System.out.println(str1 == str3);

        char[] arr2 = str3.toCharArray();


    }


}

class A {
    public void foo() {
        System.out.println("In A foo"
        );
    }
}

class B extends A {
    public void foo() {
        System.out.println("in b Foo");
        super.foo();

    }

    public void Boo() {
        System.out.println("ejdn");
    }
}
