import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class MainTest {
    @Disabled("Run manually if necessary.")
    @Test
    public void mainTimeout() {
        String[] args = new String[0];
        assertTimeout(
                ofSeconds(22),
                () -> {
                    Main.main(args);
                }
        );
    }
}
