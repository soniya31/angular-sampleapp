package stackpkg;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStackArray<E> {

    public static final int CAP = 2;
    int size = 0;
    Object element[];

    public MyStackArray() {
        element = new Object[CAP];
    }

    public Object pop() throws EmptyStackException {
        Object obj = element[--size];
        element[size] = 0;
        return obj;
    }

    public void push(E e) {
        if (size == element.length) {
            ensureCApacity();
        }
        element[size++] = e;
    }

    private void ensureCApacity() {
        int newsize = size * 2;
        element = Arrays.copyOf(element, newsize);
    }

    public static void main(String[] args) {
        MyStackArray stackArray=new MyStackArray();
        stackArray.push(10);
        stackArray.push(20);
        stackArray.push(30);
        System.out.println(stackArray.pop());
        System.out.println(stackArray.pop());

    }
}
