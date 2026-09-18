public class Member {
  final String member;
  final int memberNum;

  public Member(String member, int memberNum){
      this.member = member;
      this.memberNum = memberNum;
  }
  public String toString(){
      return member + " (Member number: " + memberNum + ")";
  }

}
