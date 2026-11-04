
import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    @Test
    void membersSortById() {
        List<Member> members = new ArrayList<>(List.of(
                new Member("Lucas", 3),
                new Member("Anna", 1),
                new Member("Peter", 2)
        ));

        Collections.sort(members);

        assertEquals(1, members.get(0).id());
        assertEquals(2, members.get(1).id());
        assertEquals(3, members.get(2).id());
    }

    @Test
    void resourcesSortByIdentifier() {
        List<Resource> resources = new ArrayList<>(List.of(
                new Resource("3", "Bog C", "Forfatter C"),
                new Resource("1", "Bog A", "Forfatter A"),
                new Resource("2", "Bog B", "Forfatter B")
        ));

        Collections.sort(resources);

        assertEquals("1", resources.get(0).getIdentifier());
        assertEquals("2", resources.get(1).getIdentifier());
        assertEquals("3", resources.get(2).getIdentifier());
    }

    @Test
    void loansSortByDueDate() {
        Resource resource = new Resource("1", "Bog", "Forfatter");
        Member member = new Member("Lucas", 1);

        List<Loan> loans = new ArrayList<>(List.of(
                new Loan(resource, member,
                        LocalDate.of(2025, 1, 10),
                        LocalDate.of(2025, 2, 20)),

                new Loan(resource, member,
                        LocalDate.of(2025, 1, 5),
                        LocalDate.of(2025, 2, 10))
        ));

        loans.sort(null);

        assertEquals(LocalDate.of(2025, 2, 10),
                loans.get(0).dueDate());
    }

    @Test
    void resourcesSortByCreator() {
        List<Resource> resources = new ArrayList<>(List.of(
                new Resource("1", "Bog B", "Zulu"),
                new Resource("2", "Bog A", "Andersen")
        ));

        Collections.sort(resources, LibraryComparators.BY_CREATOR);

        assertEquals("Andersen", resources.get(0).getCreator());
    }

    @Test
    void resourcesSortByTitle() {
        List<Resource> resources = new ArrayList<>(List.of(
                new Resource("1", "Zulu", "Forfatter A"),
                new Resource("2", "Andersen", "Forfatter B")
        ));

        resources.sort(LibraryComparators.BY_TITLE);

        assertEquals("Andersen", resources.get(0).getTitle());
    }

    @Test
    void loansSortByBorrowedDate() {
        Resource resource = new Resource("1", "Bog", "Forfatter");
        Member member = new Member("Lucas", 1);

        List<Loan> loans = new ArrayList<>(List.of(
                new Loan(resource, member,
                        LocalDate.of(2025, 2, 10),
                        LocalDate.of(2025, 3, 10)),

                new Loan(resource, member,
                        LocalDate.of(2025, 1, 10),
                        LocalDate.of(2025, 3, 20))
        ));

        loans.sort(LibraryComparators.BY_BORROWED_DATE);

        assertEquals(LocalDate.of(2025, 1, 10),
                loans.get(0).borrowedDate());
    }

    @Test
    void testCollatorSorting() {
        List<String> titles = new ArrayList<>(List.of(
                "Ø",
                "Ä",
                "Å",
                "Æ"
        ));

        Collator danish = Collator.getInstance(new Locale("da"));
        Collator swedish = Collator.getInstance(new Locale("sv"));

        titles.sort(danish);
        System.out.println("Dansk sortering: " + titles);

        titles.sort(swedish);
        System.out.println("Svensk sortering: " + titles);
    }
}
