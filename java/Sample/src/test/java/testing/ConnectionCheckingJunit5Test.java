package testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@AssumeConversion()
public class ConnectionCheckingJunit5Test {
    @Test
    public void testOnlyWhenConnected() {
        Assertions.assertTrue(3>1,"Success");
    }

    @Test
    public void testOnlyWhenConnected1() {
        Assertions.assertTrue(3>1,"Success");
    }
}
