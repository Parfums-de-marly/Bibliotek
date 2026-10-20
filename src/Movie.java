public class Movie extends Resource {
    private String director;
    private int durationMinutes;

    public Movie(String identifier, String title,
                 String studio, String director,
                 int durationMinutes) {
        super(identifier, title, studio);
        this.director = director;
        this.durationMinutes = durationMinutes;
    }

    public String getDirector() {
        return director;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public String toString() {
        return super.toString()
                + " - Instruktør: " + director
                + " - " + durationMinutes + " minutter";
    }
}