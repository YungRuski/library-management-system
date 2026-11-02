public class LibraryMapper {
    private String delimiter = ",";

    public Member fromMemberCsv(String line) {
        String[] tokens = line.split(delimiter);
        int memberID = Integer.parseInt(tokens[1]);
        return new Member(tokens[0], memberID);
    }
    public Book fromBookCsv(String line) {
        String[] tokens = line.split(delimiter);
        int pages = Integer.parseInt(tokens[3]);
        return new Book(tokens[2], tokens[1], tokens[0], pages);
    }
    public String toCsv(Member member) {
        return member.getName() + delimiter + member.getMemberID();
    }
    public String toCsv(Book book) {
        return book.getCreator() + delimiter + book.getTitle() + delimiter +
                book.getIdentifier() + delimiter + book.getPages();
    }
}
