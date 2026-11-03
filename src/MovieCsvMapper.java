public class MovieCsvMapper {

    public String toCsv(Movie movie){
        return movie.getIdentifier() + "," + movie.getTitle() + "," + movie.getStudio() + "," + movie.getDirector() + "," + movie.getDurationMinutes();
    }

    public Movie fromCsv(String line){
        String[] parts = line.split(",");

        String identifier = parts[0];
        String title = parts[1];
        String studio = parts[2];
        String director = parts[3];
        int durationMinutes = Integer.parseInt(parts[4]);

        return new Movie(identifier, title, studio, director, durationMinutes);
    }
}
