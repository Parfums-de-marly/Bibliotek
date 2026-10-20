public class AudioBook extends Resource {
    private int durationMinutes;

    public AudioBook(String identifier, String title,
                     String creator, int durationMinutes) {
        super(identifier, title, creator);
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public String toString() {
        return super.toString()
                + " - " + durationMinutes + " minutter";
    }
}