public class VideoGameCsvMapper {

    public String toCsv(VideoGame videoGame){
        return videoGame.getIdentifier() + "," + videoGame.getTitle() + "," + videoGame.getCreator() + "," + videoGame.getPlatform();
    }

    public VideoGame fromCsv(String line){
        String[] parts = line.split(",");

        String identifier = parts[0];
        String title = parts[1];
        String creator = parts[2];
        String platform = parts[3];

        return new VideoGame(identifier,title,creator,platform);
    }
}
