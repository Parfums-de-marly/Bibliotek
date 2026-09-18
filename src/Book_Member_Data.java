public class Book_Member_Data {

    public static Book[] getBooks() {
        Book book1 = new Book("Allan B. Downey", "Think Java", "9781492072508", 1);
        Book book2 = new Book("Rachel Cusk", "Omrids", "9788763851664", 2);
        Book book3 = new Book("Yuval Noah Harari", "Sapiens", "9780062316097", 3);
        Book book4 = new Book("J. R. R. Tolkien", "The Hobbit", "9780261102217", 4);
        Book book5 = new Book("George Orwell", "1984", "9780451524935", 5);
        Book book6 = new Book("George Orwell", "Animal Farm", "9780451526342", 6);
        Book book7 = new Book("J. K. Rowling", "Harry Potter", "9780747532743", 7);
        Book book8 = new Book("Stephen King", "The Shining", "9780307743657", 8);
        Book book9 = new Book("Dan Brown", "The Da Vinci Code", "9780307474278", 9);
        Book book10 = new Book("Ernest Hemingway", "The Old Man and the Sea", "9780684830490", 10);
        Book book11 = new Book("F. Scott Fitzgerald", "The Great Gatsby", "9780743273565", 11);
        Book book12 = new Book("Harper Lee", "To Kill a Mockingbird", "9780061120084", 12);
        Book book13 = new Book("Aldous Huxley", "Brave New World", "9780060850524", 13);
        Book book14 = new Book("Ray Bradbury", "Fahrenheit 451", "9781451673319", 14);
        Book book15 = new Book("J. D. Salinger", "The Catcher in the Rye", "9780316769488", 15);
        Book book16 = new Book("Herman Melville", "Moby-Dick", "9780142437247", 16);
        Book book17 = new Book("Leo Tolstoy", "War and Peace", "9780199232765", 17);
        Book book18 = new Book("Fyodor Dostoevsky", "Crime and Punishment", "9780486415871", 18);
        Book book19 = new Book("Jane Austen", "Pride and Prejudice", "9780141439518", 19);
        Book book20 = new Book("Charlotte Brontë", "Jane Eyre", "9780141441146", 20);
        Book book21 = new Book("Mark Twain", "Adventures of Huckleberry Finn", "9780142437179", 21);
        Book book22 = new Book("John Steinbeck", "Of Mice and Men", "9780140177398", 22);
        Book book23 = new Book("William Golding", "Lord of the Flies", "9780571056866", 23);
        Book book24 = new Book("Mary Shelley", "Frankenstein", "9780486282114", 24);
        Book book25 = new Book("Bram Stoker", "Dracula", "9780141439846", 25);
        Book book26 = new Book("Oscar Wilde", "The Picture of Dorian Gray", "9780141439570", 26);
        Book book27 = new Book("Victor Hugo", "Les Misérables", "9780451419439", 27);
        Book book28 = new Book("Alexandre Dumas", "The Count of Monte Cristo", "9780140449266", 28);
        Book book29 = new Book("Homer", "The Odyssey", "9780140268867", 29);
        Book book30 = new Book("Homer", "The Iliad", "9780140275360", 30);
        Book book31 = new Book("Dante Alighieri", "Inferno", "9780142437223", 31);
        Book book32 = new Book("Miguel de Cervantes", "Don Quixote", "9780060934347", 32);
        Book book33 = new Book("Gabriel García Márquez", "One Hundred Years of Solitude", "9780060883287", 33);
        Book book34 = new Book("Paulo Coelho", "The Alchemist", "9780062315007", 34);
        Book book35 = new Book("Antoine de Saint-Exupéry", "The Little Prince", "9780156012195", 35);
        Book book36 = new Book("Douglas Adams", "The Hitchhiker's Guide to the Galaxy", "9780345391803", 36);
        Book book37 = new Book("Frank Herbert", "Dune", "9780441172719", 37);
        Book book38 = new Book("Isaac Asimov", "Foundation", "9780553293357", 38);
        Book book39 = new Book("Arthur C. Clarke", "2001: A Space Odyssey", "9780451450525", 39);
        Book book40 = new Book("Philip K. Dick", "Do Androids Dream of Electric Sheep?", "9780345404473", 40);
        Book book41 = new Book("Agatha Christie", "Murder on the Orient Express", "9780062693662", 41);
        Book book42 = new Book("Arthur Conan Doyle", "The Hound of the Baskervilles", "9780553328252", 42);
        Book book43 = new Book("Stephen King", "It", "9781501142970", 43);
        Book book44 = new Book("Neil Gaiman", "American Gods", "9780380973651", 44);
        Book book45 = new Book("Suzanne Collins", "The Hunger Games", "9780439023481", 45);
        Book book46 = new Book("Veronica Roth", "Divergent", "9780062024039", 46);
        Book book47 = new Book("Khaled Hosseini", "The Kite Runner", "9781594631931", 47);
        Book book48 = new Book("Cormac McCarthy", "The Road", "9780307387899", 48);
        Book book49 = new Book("Ernest Hemingway", "A Farewell to Arms", "9780099273963", 49);
        Book book50 = new Book("Albert Camus", "The Stranger", "9780679720201", 50);

        return new Book[]{
                book1, book2, book3, book4, book5,
                book6, book7, book8, book9, book10,
                book11, book12, book13, book14, book15,
                book16, book17, book18, book19, book20,
                book21, book22, book23, book24, book25,
                book26, book27, book28, book29, book30,
                book31, book32, book33, book34, book35,
                book36, book37, book38, book39, book40,
                book41, book42, book43, book44, book45,
                book46, book47, book48, book49, book50
        };
    }

    public static Member[] getMembers(){
        Member member1 = new Member("Jens Jensen", 111);
        Member member2 = new Member("Karl Karlsen", 222);
        Member member3 = new Member("Nikolai Nikolaisen", 333);
        Member member4 = new Member("Peter Petersen", 444);
        Member member5 = new Member("Anders Andersen", 555);

        return new Member[]{member1,member2,member3,member4,member5};
    }

}
