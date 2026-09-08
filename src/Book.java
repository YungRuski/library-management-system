public class Book {
    final String title;
    final String author;
    final String isbn;
    final int idNr;
    boolean isAvailable;

    public Book(String title, String author, String isbn, int idNr) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.idNr = idNr;
        this.isAvailable = true;
    }

    public boolean loanBook() {
        if (isAvailable == true) {
         isAvailable = false;
         return true;
        }else {
            return false;
        }
    }
    public void returnBook(){
    isAvailable = true;
    }

    public String toString() {
        String status = isAvailable ? "På hylden" : "Udlånt";
        return String.format("""
                Titel: %s
                Forfatter: %s
                ISBN: %s
                ID nr: %d
                %s
                """, title, author, isbn, idNr, status);
    }
}
