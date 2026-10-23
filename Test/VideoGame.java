
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideoGameTest {

    @Test
    void testVideoGame() {
        VideoGame videoGame = new VideoGame(
                "570123456763",
                "Call of Duty",
                "Sony",
                "PS4"
        );

        assertEquals("570123456763", videoGame.getIdentifier());
        assertEquals("Call of Duty", videoGame.getTitle());
        assertEquals("Sony", videoGame.getCreator());
        assertEquals("PS4", videoGame.getPlatform());
    }
}
