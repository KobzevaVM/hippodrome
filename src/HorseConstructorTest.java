import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HorseConstructorTest {
    @Test
    void horseNameNullError() {
        assertThrows(
                IllegalArgumentException.class, () -> {
                    new Horse(null, 1.0, 1.0);
                }
        );
    }

    @Test
    void horseNameNullErrorMessage() {
        try {
            new Horse(null, 1.0, 1.0);
        }
        catch(Exception e) {
            assertEquals("Name cannot be null.", e.getMessage());

        }
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "", "\t", "  ", "  ", "   ", "    ", "\n"})
    void horseNameBlankError(String argument) {
        assertThrows(
                IllegalArgumentException.class, () -> {
                    new Horse(argument, 1.0, 1.0);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "", "\t", "  ", "  ", "   ", "    ", "\n"})
    void horseNameBlankErrorMessage(String argument) {
        try {
            new Horse(argument, 1.0, 1.0);
        }
        catch(Exception e) {
            assertEquals("Name cannot be blank.", e.getMessage());

        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.0, -5, -0.7, - 5.3})
    void horseSpeedError(double argument) {
        assertThrows(
                IllegalArgumentException.class, () -> {
                    new Horse("horseName", argument, 1.0);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.0, -5, -0.7, - 5.3})
    void horseSpeedErrorMessage(double argument) {
        try {
            new Horse("horseName", argument, 1.0);
        }
        catch(Exception e) {
            assertEquals("Speed cannot be negative.", e.getMessage());

        }
    }


    @ParameterizedTest
    @ValueSource(doubles = {-1.0, -5, -0.7, - 5.3})
    void horseDistanceError(double argument) {
        assertThrows(
                IllegalArgumentException.class, () -> {
                    new Horse("horseName", 1.0, argument);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.0, -5, -0.7, - 5.3})
    void horseDistanceErrorMessage(double argument) {
        try {
            new Horse("horseName", 1.0, argument);
        }
        catch(Exception e) {
            assertEquals("Distance cannot be negative.", e.getMessage());

        }
    }
}
