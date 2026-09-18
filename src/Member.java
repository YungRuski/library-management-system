public record Member(String name, int memberID) {

    @Override
    public String toString() {
        return String.format("""
                %s (Lånenummer: %s)
                """, name, memberID);
    }
}
