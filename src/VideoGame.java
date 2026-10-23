public class VideoGame extends Resource {
    private String platform;

    public VideoGame(String identifier, String title, String studio, String platform) {
        super(identifier, title, studio);
        this.platform = platform;
    }


    public String getPlatform() {
        return platform;
    }



    @Override
    public String toString() {
        return super.toString()
                + " - Platform: " + platform;
    }
}