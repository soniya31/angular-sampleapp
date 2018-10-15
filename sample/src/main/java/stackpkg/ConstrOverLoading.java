package stackpkg;

 class ConstrOverLoading {
    int a;
    double b;
    private ConstrOverLoading(int a, double b){
        this.a = a;
        this.b = b;
    }
    private ConstrOverLoading(int a){
        this(a, 0.0);
    }
    private ConstrOverLoading(){
        this(0);
    }


}
