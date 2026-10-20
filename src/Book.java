public class Book extends Resource {

    private int pages;

    public Book(String identifier, String title, String creator, int pages){
        super(identifier, title, creator);
        this.pages = pages;
    }

    public int getPages(){
        return this.pages;
    }
    @Override
    public String toString() {
        return String.format("""
                %s; %s
                ISBN: %s
                Pages: %s
                """, getCreator(), getTitle(), getIdentifier(), getPages());
    }
}


