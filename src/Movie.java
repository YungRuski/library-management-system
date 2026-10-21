public class Movie extends Resource {
    private String director;
    private int movieLength;

    public Movie (String identifier, String title, String creator, String director, int movieLength){
        super(identifier, title, creator);
        this.director = director;
        this.movieLength = movieLength;
    }

    public String getDirector(){
        return this.director;
    }

    public int getMovieLength(){
        return this.movieLength;
    }

    @Override
    public String toString(){
        return String.format("""
                Film: %s - %s
                EAN: %s
                Instruktør: %s
                Varighed: %d minutter
                """,getTitle(), getCreator(), getIdentifier(), getDirector(),getMovieLength());
    }

}

