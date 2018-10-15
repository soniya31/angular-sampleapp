package testing;

  class StaticDEmo {

      public void ffg(){}

    /*  public void absDemo();*/
     static class F{
      public void getStatic(){
          System.out.println("In get Static Method");
      }
     }
}

class child extends StaticDEmo{

   // @Override
    public void absDemo() {
        System.out.println("In sdfhysdff");
    }

    public static void main(String[] args) {
        StaticDEmo.F s = new StaticDEmo.F();
        s.getStatic();
       // s.absDemo();
       // StaticDEmo.F;

    }
}

