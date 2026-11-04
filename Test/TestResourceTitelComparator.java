import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestResourceTitelComparator {

    @Test
    void TestResourceTitelComparator() {

        String title1 = "Harry Potter";
        String title2 = "Moby Dick";
        Resource resource1 = new Resource (null, title1, null);
        Resource resource2 = new Resource  (null, title2, null);
        List<Resource> resourcesList = new ArrayList<>();

        resourcesList.add(resource2);
        resourcesList.add(resource1);

        Collections.sort(resourcesList, new ResourceTitelComparator());

        assertEquals(title1, resourcesList.getFirst().getTitle());
    }
}
