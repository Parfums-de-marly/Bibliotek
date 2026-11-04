import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryCsvMapperTest {

    private final LibraryCsvMapper mapper = new LibraryCsvMapper();

    @Test
    void memberCanBeConvertedToAndFromCsv() {
        String csv = "1,Harry Potter";

        Member member = mapper.memberFromCsv(csv);

        assertEquals(csv, mapper.toCsv(member));
    }

    @Test
    void bookCanBeConvertedToAndFromCsv() {
        String csv = "B1,Harry Potter,J.K. Rowling,350";

        Book book = mapper.bookFromCsv(csv);

        assertEquals(csv, mapper.toCsv(book));
    }

    @Test
    void movieCanBeConvertedToAndFromCsv() {
        String csv = "M1,The Matrix,Warner Bros,Lana Wachowski,136";

        Movie movie = mapper.movieFromCsv(csv);

        assertEquals(csv, mapper.toCsv(movie));
    }

    @Test
    void audioBookCanBeConvertedToAndFromCsv() {
        String csv = "A1,The Hobbit,J.R.R. Tolkien,680";

        AudioBook audioBook = mapper.audioBookFromCsv(csv);

        assertEquals(csv, mapper.toCsv(audioBook));
    }

    @Test
    void videoGameCanBeConvertedToAndFromCsv() {
        String csv = "V1,Minecraft,Mojang,PC";

        VideoGame videoGame = mapper.videoGameFromCsv(csv);

        assertEquals(csv, mapper.toCsv(videoGame));
    }
}
