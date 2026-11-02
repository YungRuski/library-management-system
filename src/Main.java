void main(String[] args) {
    String libraryPath = args[0];

    LoanPolicy aalborgLoanPolicy = new AalborgLoanPolicy();
    LoanPolicy bornholmLoanPolicy = new BornholmLoanPolicy();
    LoanPolicy standardLoanPolicy = new StandardLoanPolicy();
    LibraryMapper mapper = new LibraryMapper();
    LibraryLoader loader = new LibraryLoader(mapper);
    Library library = new Library(bornholmLoanPolicy);


    Path memberPath = Path.of(libraryPath, "members.csv");
    try {
        List<Member> loadedMembers = loader.loadMembers(memberPath);
        for (Member member : loadedMembers) {
            library.addMember(member);
        }
    } catch (IOException e) {
        IO.println("Der er sket en fejl: " + e.getLocalizedMessage());
    }
    Path bookPath = Path.of(libraryPath, "books.csv");
    try {
        List<Book> loadedBooks = loader.loadBooks(bookPath);
        for (Book book : loadedBooks) {
            library.addResource(book);
        }
    } catch (IOException e) {
        IO.println("Der er sket en fejl: " + e.getLocalizedMessage());
    }
    Path moviePath = Path.of(libraryPath, "movies.csv");
    try {
        List<Movie> loadedMovies = loader.loadMovies(moviePath);
        for (Movie movie : loadedMovies) {
            library.addResource(movie);
        }
    } catch (IOException e) {
        IO.println("Der er sket en fejl: " + e.getLocalizedMessage());
    }
    Path audiobookPath = Path.of(libraryPath, "audiobooks.csv");
    try {
        List<AudioBook> audioBooks = loader.loadAudioBooks(audiobookPath);
        for (AudioBook audioBook : audioBooks) {
            library.addResource(audioBook);
        }
    } catch (IOException e) {
        IO.println("Der er sket en fejl: " + e.getLocalizedMessage());
    }
    Path videoGamesPath = Path.of(libraryPath, "videogames.csv");
    try {
        List<VideoGame> loadedVideoGames = loader.loadVideoGames(videoGamesPath);
        for (VideoGame videoGame : loadedVideoGames) {
            library.addResource(videoGame);
        }
    } catch (IOException e) {
        IO.println("Der er sket en fejl: " + e.getLocalizedMessage());
    }


    ConsoleUI consoleUI = new ConsoleUI(library);

    consoleUI.run();


}


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
