public record Member(String name, int memberID) {

    @Override
    public String toString() {
        return String.format("""
                %s (Lånenummer: %s)
                """, name, memberID);
    }
    public String getName() {
        return name;
    }
    public int getMemberID() {
        return memberID;
    }
}
