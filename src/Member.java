public record Member(String name, int id) implements Comparable<Member> {

    @Override
    public int compareTo(Member other) {
        return Integer.compare(this.id, other.id);
    }

}