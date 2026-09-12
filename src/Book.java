public class Book {
    final String title;
    final String author;
    final String isbn;
    final int idNr;


    public Book(String title, String author, String isbn, int idNr) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.idNr = idNr;

    }


    public String toString() {

        return String.format("""
                Titel: %s
                Forfatter: %s
                ISBN: %s
                ID nr: %s
                """, title, author, isbn, idNr);
    }
}
