void main(String[] args) {
    String libraryPath = args[0];

    LoanPolicy aalborgLoanPolicy = new AalborgLoanPolicy();
    LoanPolicy bornholmLoanPolicy = new BornholmLoanPolicy();
    LoanPolicy standardLoanPolicy = new StandardLoanPolicy();
    LibraryMapper mapper = new LibraryMapper();
    LibraryLoader loader = new LibraryLoader(mapper);
    LibrarySaver saver = new LibrarySaver(mapper);
    Library library = new Library(bornholmLoanPolicy);


    Path memberPath = Path.of(libraryPath, "members.csv");
    Path bookPath = Path.of(libraryPath, "books.csv");
    Path moviePath = Path.of(libraryPath, "movies.csv");
    Path audiobookPath = Path.of(libraryPath, "audiobooks.csv");
    Path videoGamesPath = Path.of(libraryPath, "videogames.csv");
    Path loansPath = Path.of(libraryPath, "loans.csv");


    try {
        List<Member> loadedMembers = loader.loadMembers(memberPath);
        for (Member member : loadedMembers) {
            library.addMember(member);
        }
        List<Book> loadedBooks = loader.loadBooks(bookPath);
        for (Book book : loadedBooks) {
            library.addResource(book);
        }
        List<Movie> loadedMovies = loader.loadMovies(moviePath);
        for (Movie movie : loadedMovies) {
            library.addResource(movie);
        }
        List<AudioBook> audioBooks = loader.loadAudioBooks(audiobookPath);
        for (AudioBook audioBook : audioBooks) {
            library.addResource(audioBook);
        }
        List<VideoGame> loadedVideoGames = loader.loadVideoGames(videoGamesPath);
        for (VideoGame videoGame : loadedVideoGames) {
            library.addResource(videoGame);
        }
        List<Loan> loans = loader.loadLoans(loansPath, library);
        for (Loan loan : loans) {
            library.addLoan(loan);
        }

    } catch (IOException e) {
        IO.println("Der er sket en fejl: " + e.getLocalizedMessage());
    }


    ConsoleUI consoleUI = new ConsoleUI(library, saver, loansPath);
    consoleUI.run();
}
