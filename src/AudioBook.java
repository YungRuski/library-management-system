public class AudioBook extends Resource {
    private int audioLength;

    public AudioBook(String identifier, String title, String creator, int audioLength) {
        super(identifier, title, creator);
        this.audioLength = audioLength;
    }

    public int getAudioLength(){
        return this.audioLength;
    }

    @Override
    public String toString(){
        return String.format("""
                %s; %s
                ISBN: %s
                Varighed: %d minutter
                """,getCreator(), getTitle(), getIdentifier(), getAudioLength());
    }
}
