public class Member {
    final String name;
    final int memberID;

    Member(String name, int memberID) {
        this.name = name;
        this.memberID = memberID;
    }

    public String toString() {
        return String.format("""
                %s (Lånenummer: %s)
                """, name, memberID);
    }

}
