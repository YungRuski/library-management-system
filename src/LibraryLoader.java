import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LibraryLoader {
    private LibraryMapper mapper;

    public LibraryLoader(LibraryMapper mapper) {
        this.mapper = mapper;
    }

    public List<Member> loadMembers(Path path) throws IOException {
        List<Member> members = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                members.add(mapper.fromMemberCsv(line));
            }
        }
        return members;
    }

    public List<Book> loadBooks(Path path) throws IOException {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                books.add(mapper.fromBookCsv(line));
            }
        }
        return books;
    }

    public List<Movie> loadMovies(Path path) throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                movies.add(mapper.fromMovieCsv(line));
            }
        }
        return movies;
    }

    public List<AudioBook> loadAudioBooks(Path path) throws IOException {
        List<AudioBook> audioBooks = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                audioBooks.add(mapper.fromAudioBookCsv(line));
            }
        }
        return audioBooks;
    }

    public List<VideoGame> loadVideoGames(Path path) throws IOException {
        List<VideoGame> videoGames = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                videoGames.add(mapper.fromVideoGameCsv(line));
            }
        }
        return videoGames;
    }

    public List<Loan> loadLoans(Path path, Library library) throws IOException {
        List<Loan> loans = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                loans.add(mapper.fromLoanCsv(line, library));
            }
        }
        return loans;
    }
}
