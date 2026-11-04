import java.util.Comparator;

public class ResourceTitelComparator implements Comparator <Resource> {

    @Override
    public int compare(Resource resource1, Resource resource2) {
        return resource1.getTitle().compareTo(resource2.getTitle());
    }

}
