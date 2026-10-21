public class VideoGame extends Resource {
    private String platform;

    public VideoGame(String identifier, String title, String creator, String platform){
        super(identifier, title, creator);
        this.platform = platform;
    }
    public String getPlatform(){
        return this.platform;
    }
    @Override
    public String toString(){
        return String.format("""
                Titel: %s (%s)
                Spilproducent: %s
                EAN: %s
                """,getTitle(), getPlatform(), getCreator(), getIdentifier());
    }
}
