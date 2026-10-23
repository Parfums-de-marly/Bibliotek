public class Movie extends Resource {
    private String director;
    private int durationMinutes;
    private String studio;

    public Movie(String identifier, String title, String studio, String director, int durationMinutes) {
        super(identifier, title, studio);
        this.durationMinutes = durationMinutes;
        this.director = director;
        this.studio = studio;
    }


    public String getDirector() {
        return director;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getStudio(){
        return studio;
    }


    @Override
    public String toString() {
        return super.toString()
                + " - Instruktør: " + director
                + " - " + durationMinutes + " minutter";
    }
}