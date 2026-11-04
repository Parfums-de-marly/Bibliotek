import java.util.Comparator;
import java.text.Collator;
import java.util.Locale;

public class LibraryComparators {

    public static final Comparator<Resource> BY_CREATOR =
            Comparator.comparing(Resource::getCreator);
    Collator collator = Collator.getInstance(new Locale ("da"));

    public static final Comparator<Resource> BY_TITLE =
            Comparator.comparing(Resource::getTitle);

    public static final Comparator<Loan> BY_BORROWED_DATE =
            Comparator.comparing(Loan::borrowedDate);
}