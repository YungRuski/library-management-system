public record Member(String name, int memberID) implements Comparable<Member> {

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
    @Override
    public int compareTo(Member other) {
        return Integer.compare(this.memberID, other.memberID);
    }
}
