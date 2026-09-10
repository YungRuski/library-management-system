void main() {
    Book book1 = new Book("Krig og Fred", "Lev Tolstoj", "9788702294903", 1);
    IO.println(book1);

    Book book2 = new Book("Vagabond", "Tekhiko Inour", "9849864359458", 2);
    IO.println(book2);

    Book book3 = new Book("One Piece", "Eichiro Oda", "928984953849", 3);
    IO.println(book3);

    Member member1 = new Member("Jan", 5932);
    Member member2 = new Member("Amanda", 9582);

    IO.println(book1);
    boolean loaned = book1.loanBook(member1);
    IO.println(book1);

    book1.returnBook();
    IO.println(book1);


}