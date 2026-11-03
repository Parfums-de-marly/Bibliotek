public class AudioBookCsvMapper {

    public String toCsv(AudioBook audioBook){
        return audioBook.getIdentifier() + "," + audioBook.getTitle() + "," + audioBook.getCreator() + "," + audioBook.getDurationMinutes();
    }

    public AudioBook fromCsv(String line){
        String[] parts = line.split(",");

        String identifier = parts[0];
        String title = parts[1];
        String creator = parts[2];
        int durationMinutes = Integer.parseInt(parts[3]);

        return new AudioBook(identifier, title, creator, durationMinutes);
    }
}
