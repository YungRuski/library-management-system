void main() {

    Library library = new Library();
    ConsoleUI consoleUI = new ConsoleUI(library);

    // Bøger
    library.addResource(new Book("9788700631625", "Harry Potter", "J.K. Rowling", 350));

    library.addResource(new Book("9780451524935", "1984", "George Orwell", 328));

// Film
    library.addResource(new Movie("5700000000001", "Toy Story", "Pixar", "John Lasseter", 81));

    library.addResource(new Movie("5700000000002", "Interstellar", "Paramount Pictures", "Christopher Nolan", 169));

// Computerspil
    library.addResource(new VideoGame("5700000000003", "Minecraft", "Mojang", "PC"));

    library.addResource(new VideoGame("5700000000004", "The Legend of Zelda: Breath of the Wild", "Nintendo", "Nintendo Switch"));

// Lydbøger
    library.addResource(new AudioBook("9788700631626", "Harry Potter", "J.K. Rowling", 540));

    library.addResource(new AudioBook("9780451524936", "1984", "George Orwell", 660));

    Member member1 = new Member("Jan", 5932);
    Member member2 = new Member("Amanda", 9582);
    Member member3 = new Member("Michael", 8312);

    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);

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
