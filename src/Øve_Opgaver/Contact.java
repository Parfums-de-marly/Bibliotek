package Øve_Opgaver;

public class Contact {
        String name;
        String email;

        public Contact(String name, String email) {
            this.name = name;
            this.email = email;

        }

        public String toString() {
        return String.format("%s <%s>", name, email);
        }
    }


