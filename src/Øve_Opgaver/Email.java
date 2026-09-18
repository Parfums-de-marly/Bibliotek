package Øve_Opgaver;

public class Email {
    Contact to;
    Contact from;
    String subject;
    String body;

    public Email(Contact from, Contact to, String subject, String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        }

    public String toString() {
        return String.format("""
        From: %s
        To: %s
        Subject: %s
        %s
        """,from, to, subject, body);
    }



}
