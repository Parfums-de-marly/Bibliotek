import Øve_Opgaver.Contact;
import Øve_Opgaver.Email;

void main() {

    Email email1 = new Email(
            new Contact("Mikkel","mikkel1@gmail.com"),
            new Contact ("Sofie", "Sofie22@gmail.com"),
            "Møde",
            "Vi ses til mødet i morgen"
    );

    Email[] emails = {email1};

    for (Email email : emails) {
        IO.println(email);
    }


}

