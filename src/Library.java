import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Resource> resources = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final List<Loan> loans = new ArrayList<>();
    private final LoanPolicy loanPolicy;

    public Library(LoanPolicy loanPolicy){
        this.loanPolicy = loanPolicy;
    }

    public Resource getResource(String identifier) {
        for (Resource resource : resources) {
            if (resource.getIdentifier().equals(identifier)) {
                return resource;
            }
        }

        return null;
    }

    public Member getMember(int memberId) {
        for (Member member : members) {
            if (member.id() == memberId) {
                return member;
            }
        }

        return null;
    }

    public LoanResult loan(String identifier, int memberId) {
        Member member = getMember(memberId);

        if (member == null) {
            return LoanResult.MEMBER_NOT_REGISTERED;
        }

        Resource resource = getResource(identifier);

        if (resource == null) {
            return LoanResult.RESOURCE_NOT_REGISTERED;
        }


        for (Loan loan : loans) {
            if (loan.resource().getIdentifier().equals(identifier)) {
                return LoanResult.RESOURCE_ALREADY_LOANED;
            }
        }

        if (!loanPolicy.canLoan(resource, loans, member)){
            return LoanResult.NOT_PERMITTED;
        }

        LocalDate borrowedDate = LocalDate.now();

        LocalDate dueDate = loanPolicy.calculateDueDate(resource, borrowedDate);


        Loan loan = new Loan(resource, member, borrowedDate, dueDate);
        loans.add(loan);

        return LoanResult.SUCCESS;

    }

    public boolean returnLoan(String identifier, int memberId) {
        for (int i = 0; i < loans.size(); i++) {
            Loan loan = loans.get(i);

            if (loan.resource().getIdentifier().equals(identifier)
                    && loan.member().id() == memberId) {
                loans.remove(i);
                return true;
            }
        }

        return false;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public List<Resource> getResources() {
        return List.copyOf(resources);
    }

    public List<Loan> getLoans() {
        return List.copyOf(loans);
    }

    public List<Loan> findLoansByMemberId(int memberId) {
        List<Loan> result = new ArrayList<>();

        for (Loan loan : loans) {
            if (loan.member().id() == memberId) {
                result.add(loan);
            }
        }

        return result;
    }
}