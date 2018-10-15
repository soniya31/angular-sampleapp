package sort;

public class Em {
    int id;
    int name;

    public Em(int id, int name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        //if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Em em = (Em) o;
if(this==o)return true;
        //if (id != em.id) return false;
       return id == em.id;
    }



}
