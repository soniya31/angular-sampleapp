package pratices;

import java.util.ArrayList;

public class CustomHashMap<A,B>{

    Entry<A,B>[] table;
    int capacity;

    CustomHashMap(int capacity){
        this.capacity = capacity;
        table = new Entry[capacity];
    }
    public void put(A key, B value){

    if(key == null)
        return;
    int index = hash(key);
    Entry<A,B> e = new Entry<A,B>(key,value,null);

    if(table[index] == null){
        table[index] = e;
    }
    else{
        Entry<A,B> prev;
        while(table[index].next != null){

        }
    }



    }
   /* public B get(A key){


    }*/


    private int hash(A key){
        return Math.abs(key.hashCode()) % capacity;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    static class Entry<A,B>{
        A key;
        B value;
        Entry<A,B> next ;

        public Entry(A key, B value,Entry<A,B> entry ) {
            this.key = key;
            this.value = value;
            this.next = entry  ;
        }

        public A getKey() {
            return key;
        }

        public void setKey(A key) {
            this.key = key;
        }

        public B getValue() {
            return value;
        }

        public void setValue(B value) {
            this.value = value;
        }
    }
}
