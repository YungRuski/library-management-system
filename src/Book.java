public record Book(String title, String author, String isbn, int idNr) {

    @Override
    public String toString() {
        return String.format("""
                %s; %s
                ISBN: %s
                ID nr: %s
                """, author, title, isbn, idNr);
    }
}
