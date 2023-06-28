import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HippodromeTest {
    @Test
    void hippodromeEmptyList() {
        assertThrows(
                IllegalArgumentException.class, () -> {
                    new Hippodrome(null);
                }
        );
    }

    @Test
    void hippodromeEmptyListMessage() {
        try {
            new Hippodrome(null);
        }
        catch(Exception e) {
            assertEquals("Horses cannot be null.", e.getMessage());

        }
    }

    @Test
    void hippodromeBlankListError() {
        assertThrows(
                IllegalArgumentException.class, () -> {
                    new Hippodrome(List.of());
                }
        );
    }

    @Test
    void hippodromeBlankListErrorMessage() {
        try {
            new Hippodrome(List.of());
        }
        catch(Exception e) {
            assertEquals("Horses cannot be empty.", e.getMessage());
        }
    }

    @Test
    void hippodromeGetHorses() {
        String name = "Name";
        double speed = 1.0;
        List<Horse> horses = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            horses.add(new Horse(name + String.valueOf(i), speed + (double) i /10.0));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertIterableEquals(horses, hippodrome.getHorses());
    }

    @Test
    void moveTest() {
        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(Mockito.mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        for (int i = 0; i < 50; i++) {
            Mockito.verify(horses.get(i)).move();
        }
    }

    @Test
    void hippodromeGetWinner() {
        String name = "Name";
        double speed = 1.0;
        double distance = 1.0;
        List<Horse> horses = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            horses.add(new Horse(name + String.valueOf(i), speed + (double) i /10.0,
                    distance + (double) i / 10.0));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        /*
        Horse winner = hippodrome.getHorses().get(0);
        double maxDistance = hippodrome.getHorses().get(0).getDistance();
        for(Horse h : hippodrome.getHorses()) {
            if(h.getDistance() > maxDistance) {
                winner = h;
                maxDistance = h.getDistance();
            }
        }
        */
        assertEquals(hippodrome.getHorses().get(29), hippodrome.getWinner());
    }
}
