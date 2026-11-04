public class MemberCsvMapper {

    public String toCsv(Member member){

        return member.name() + "," + member.id();
    }

    public Member fromCsv(String line){
        String[] parts = line.split(",");

        String name = parts[0];
        int id = Integer.parseInt(parts[1]);

        return new Member(name, id);


    }
}
