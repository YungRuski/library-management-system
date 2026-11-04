import java.time.LocalDate;

public class LibraryMapper {
    private String delimiter = ",";

    public String toCsv(Member member) {
        return member.getName() + delimiter + member.getMemberID();
    }

    public Member fromMemberCsv(String line) {
        String[] tokens = line.split(delimiter);
        int memberID = Integer.parseInt(tokens[1]);
        return new Member(tokens[0], memberID);
    }

    public String toCsv(Book book) {
        return book.getCreator() + delimiter + book.getTitle() + delimiter +
                book.getIdentifier() + delimiter + book.getPages();
    }

    public Book fromBookCsv(String line) {
        String[] tokens = line.split(delimiter);
        int pages = Integer.parseInt(tokens[3]);
        return new Book(tokens[2], tokens[1], tokens[0], pages);
    }

    public String toCsv(Movie movie) {
        return movie.getTitle() + delimiter + movie.getCreator() + delimiter +
                movie.getIdentifier() + delimiter + movie.getDirector() + delimiter +
                movie.getMovieLength();
    }

    public Movie fromMovieCsv(String line) {
        String[] tokens = line.split(delimiter);
        int movieLength = Integer.parseInt(tokens[4]);
        return new Movie(tokens[2], tokens[0], tokens[1], tokens[3], movieLength);
    }

    public String toCsv(AudioBook audioBook) {
        return audioBook.getCreator() + delimiter + audioBook.getTitle() + delimiter +
                audioBook.getIdentifier() + delimiter + audioBook.getAudioLength();
    }

    public AudioBook fromAudioBookCsv(String line) {
        String[] tokens = line.split(delimiter);
        int audioLength = Integer.parseInt(tokens[3]);
        return new AudioBook(tokens[2], tokens[1], tokens[0], audioLength);
    }

    public String toCsv(VideoGame videoGame) {
        return videoGame.getTitle() + delimiter + videoGame.getPlatform() + delimiter +
                videoGame.getCreator() + delimiter + videoGame.getIdentifier();
    }

    public VideoGame fromVideoGameCsv(String line) {
        String[] tokens = line.split(delimiter);
        return new VideoGame(tokens[3], tokens[0], tokens[2], tokens[1]);
    }

    public String toCsv(Loan loan) {
        return loan.getResource().getIdentifier() + delimiter + loan.getMember().getMemberID() + delimiter + loan.getBorrowedDate() +
                delimiter + loan.getDueDate();
    }

    public Loan fromLoanCsv(String line, Library library) {
        String[] tokens = line.split(delimiter);
        LocalDate borrowedDate = LocalDate.parse(tokens[2]);
        LocalDate dueDate = LocalDate.parse(tokens[3]);
        int memberId = Integer.parseInt(tokens[1]);
        return new Loan(library.getResource(tokens[0]), library.getMember(memberId), borrowedDate, dueDate);
    }


}
