import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class HorseMethodsTest {
    @Test
    void horseGetName() {
        Horse horse = new Horse("Name", 1, 0);
        assertEquals("Name", horse.getName());
    }

    @Test
    void horseGetSpeed() {
        Horse horse = new Horse("Name", 1, 0);
        assertEquals(1, horse.getSpeed());
    }

    @Test
    void horseGetDistance() {
        Horse horse = new Horse("Name", 1, 2);
        assertEquals(2, horse.getDistance());
    }
    @Test
    void horseGetDistanceEmpty() {
        Horse horse = new Horse("Name", 1);
        assertEquals(0, horse.getDistance());
    }
    @ParameterizedTest
    @ValueSource(doubles = {0.2, 0.8889})
    void horseMoveRandom(double argument) {
        try(MockedStatic<Horse> horse = Mockito.mockStatic(Horse.class)) {
            new Horse("Name", 1).move();
            horse.verify(() -> Horse.getRandomDouble(0.2, 0.9));
            //Mockito.verify(horse.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(argument));
        } catch(Exception e) {

        }
    }
    @ParameterizedTest
    @ValueSource(doubles = {0.2, 0.5, 0.7, 0.8889})
    void horseDistanceFormula(double argument) {
        try(MockedStatic<Horse> horse = Mockito.mockStatic(Horse.class)) {
            Horse horse1 = new Horse("Name", 1);
            double distance1 = horse1.getDistance();
            horse.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(argument);
            horse1.move();
            assertEquals(distance1 + horse1.getSpeed() * argument, horse1.getDistance());
        } catch(Exception e) {

        }
    }
}
