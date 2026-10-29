import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class MovieTest {
    @Test
    void testMovie() {
        Movie movie = new Movie("5701234567890", "The Odyssey", "Warner Bros.", "Christopher Nolan", 120);
        String identifier = movie.getIdentifier();
        String title = movie.getTitle();
        String studio = movie.getStudio();
        String director = movie.getDirector();
        int duration = movie.getDurationMinutes();

        assertEquals("5701234567890", identifier);
        assertEquals("The Odyssey", title);
        assertEquals("Warner Bros.", studio);
        assertEquals("Christopher Nolan", director);
        assertEquals(120, duration);

    }
}