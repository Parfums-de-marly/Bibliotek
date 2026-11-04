
import java.util.Comparator;

public class LibraryComparators {

    public static final Comparator<Resource> BY_CREATOR =
            Comparator.comparing(Resource::getCreator);

    public static final Comparator<Resource> BY_TITLE =
            Comparator.comparing(Resource::getTitle);

    public static final Comparator<Loan> BY_BORROWED_DATE =
            Comparator.comparing(Loan::borrowedDate);
}
