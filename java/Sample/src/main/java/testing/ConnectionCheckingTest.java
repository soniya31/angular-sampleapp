package testing;

import org.junit.jupiter.api.Test;

import static org.junit.Assume.assumeTrue;

public class ConnectionCheckingTest {
    private AccessCQServer connectionChecker =
            new AccessCQServer();

    @Test
    public void testOnlyWhenConnected() {
       // assumeTrue(connectionChecker.connect());
        System.out.println("sdjhjhjk");

    }

}
