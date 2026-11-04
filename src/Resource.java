public abstract class Resource implements Comparable<Resource> {
    private String identifier;
    private String title;
    private String creator;

    public Resource (String identifier, String title, String creator){
        this.identifier = identifier;
        this.title = title;
        this.creator = creator;
    }
    public String getIdentifier(){
        return this.identifier;
    }
    public String getTitle(){
        return this.title;
    }
    public String getCreator(){
        return this.creator;
    }
    @Override
    public int compareTo(Resource other) {
        return this.getIdentifier().compareTo(other.getIdentifier());
    }
}
