void main() {
    Book book1 = new Book("Krig og Fred", "Lev Tolstoj", "9788702294903", 1);


    Book book2 = new Book("Vagabond", "Tekhiko Inour", "9849864359458", 2);


    Book book3 = new Book("One Piece", "Eichiro Oda", "928984953849", 3);


    book1.loanBook();
    IO.println(book1);

    book1.returnBook();
    IO.println(book1);
}