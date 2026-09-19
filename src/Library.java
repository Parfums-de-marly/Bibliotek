import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
public class Library {

    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public Book getBook(int bookId){
      for (Book book : books){
          if (book.id() == bookId){
              return book;
          }
      }
        return null;
    }

    public Member getMember(int memberId){
        for (Member member : members){
            if (member.id() == memberId){
                return member;
            }
        }
        return null;
    }

    public boolean loanBook(int bookId, int memberId) {
        Member member = getMember(memberId);
        Book book = getBook(bookId);

        if (member != null && book != null) {

            for (Loan loan : loans) {
                if (loan.book().id() == bookId) {
                    return false;
                }
            }

            Loan loan = new Loan(book, member, LocalDate.now());
            addloan(loan);

            return true;
        }

        return false;
    }

    public boolean returnBook(int bookId) {
        for (int i = 0; i < loans.size(); i++) {
            Loan loan = loans.get(i);

            if (loan.book().id() == bookId) {
                loans.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Loan> findLoansByMemberId(int memberId){
        ArrayList<Loan> result = new ArrayList<>();

        for (Loan loan : loans){
            if (loan.member().id() == memberId){
                result.add(loan);
            }
        }
        return result;
    }

    public void addMember(Member member){
        members.add(member);
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void addloan(Loan loan){
        loans.add(loan);
    }

    /*
    public List<Book> getBooks(){
        return books;
    }

    public List<Member> getMembers(){
        return members;
    }

    public List<Loan> getLoans(){
        return loans;
    }

    public void printBooks(){
        for (Book book : books){
            IO.println(book);
        }
    }

    public void printMembers(){
        for (Member member : members){
            IO.println(member);
        }
    }

    public void printLoans(){
        for (Loan loan: loans){
            IO.println(loan);
        }
    }



     */




}
