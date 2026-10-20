void main() {

    Library library = new Library();
    ConsoleUI consoleUI = new ConsoleUI(library);

    Book book1 = new Book("Krig og Fred", "Lev Tolstoj", "9788702294903", 1);
    Book book2 = new Book("Vagabond", "Tekhiko Inour", "9849864359458", 2);
    Book book3 = new Book("One Piece", "Eichiro Oda", "928984953849", 3);

    Member member1 = new Member("Jan", 5932);
    Member member2 = new Member("Amanda", 9582);
    Member member3 = new Member("Michael", 8312);

    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);

    consoleUI.run();


}
//    ArrayList<Book> books = new ArrayList<>();
//    books.add(new Book("Krig og Fred", "Lev Tolstoj", "9788702294903", 1));
//    books.add(new Book("Vagabond", "Tekhiko Inour", "9849864359458", 2));
//
//    boolean isBookFound = books.contains(new Book("Krig og Fred", "Lev Tolstoj", "9788702294903", 1));
//    IO.println(isBookFound);

/*
    library.loanBook(1, 5932);
    library.loanBook(2, 5932);
    ArrayList<Loan> loans = library.findLoansByMemberId(5932);
    IO.println(loans);

    library.loanBook(3, 9582);
    loans = library.findLoansByMemberId(9582);
    IO.println(loans);


    //Nu returnere jeg en bog.
    IO.println(library.returnBook(1));
    loans = library.getLoans();
    IO.println(library.returnBook(1));

//    Book foundBook = library.getBook(1);
//    IO.println(foundBook);
//
//    Member foundMember = library.getMember(5932);
//    IO.println(foundMember);


//library.printBooks();
//library.printMembers();

    //bruger equals metoden til at tjekke, bruger min egen equals metode
    //IO.println(book1.equals(book4));


    //  Loan loan1 = new Loan(book1, member1, LocalDate.of(1998, 12, 22));
    //  Loan loan2 = new Loan(book2, member1, LocalDate.now());

 */
