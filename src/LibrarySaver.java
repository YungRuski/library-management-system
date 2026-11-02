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
}
