package testing;

public class Condition   {

    public boolean isSatisfied() {
        return !System.getProperty( "os.name" ).startsWith( "Windows" );
    }
}
