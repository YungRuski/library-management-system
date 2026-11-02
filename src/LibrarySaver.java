import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LibrarySaver {
    private final Path path;
    private final LibraryMapper mapper;

    public LibrarySaver(Path path, LibraryMapper mapper) {
        this.path = path;
        this.mapper = mapper;
    }
    public void saveMembers(List<Member> members) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member member : members) {
                writer.write(mapper.toCsv(member));
                writer.write("\n");
            }
        }
    }
    public void saveBooks(List<Book> books) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Book book : books) {
                writer.write(mapper.toCsv(book));
                writer.write("\n");
            }
        }
    }
    public void saveMovies(List<Movie> movies) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Movie movie : movies) {
                writer.write(mapper.toCsv(movie));
                writer.write("\n");
            }
        }
    }
    public void saveAudioBooks(List<AudioBook> audioBooks) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AudioBook audioBook : audioBooks) {
                writer.write(mapper.toCsv(audioBook));
                writer.write("\n");
            }
        }
    }

    public void saveVideoGames (List<VideoGame> videoGames) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (VideoGame videoGame : videoGames) {
                writer.write(mapper.toCsv(videoGame));
                writer.write("\n");
            }
        }
    }
}
