import java.util.List;

public class Book_Member_Data {

    public static List<Book> getBooks(){
        return List.of(
                new Book("Allan B. Downey", "Think Java", "9781492072508", 1),
                new Book("Rachel Cusk", "Omrids", "9788763851664", 2),
                new Book("Yuval Noah Harari", "Sapiens", "9780062316097", 3),
                new Book("J. R. R. Tolkien", "The Hobbit", "9780261102217", 4),
                new Book("George Orwell", "1984", "9780451524935", 5),
                new Book("George Orwell", "Animal Farm", "9780451526342", 6),
                new Book("J. K. Rowling", "Harry Potter", "9780747532743", 7),
                new Book("Stephen King", "The Shining", "9780307743657", 8),
                new Book("Dan Brown", "The Da Vinci Code", "9780307474278", 9),
                new Book("Ernest Hemingway", "The Old Man and the Sea", "9780684830490", 10),
                new Book("F. Scott Fitzgerald", "The Great Gatsby", "9780743273565", 11),
                new Book("Harper Lee", "To Kill a Mockingbird", "9780061120084", 12),
                new Book("Aldous Huxley", "Brave New World", "9780060850524", 13),
                new Book("Ray Bradbury", "Fahrenheit 451", "9781451673319", 14),
                new Book("J. D. Salinger", "The Catcher in the Rye", "9780316769488", 15),
                new Book("Herman Melville", "Moby-Dick", "9780142437247", 16),
                new Book("Leo Tolstoy", "War and Peace", "9780199232765", 17),
                new Book("Fyodor Dostoevsky", "Crime and Punishment", "9780486415871", 18),
                new Book("Jane Austen", "Pride and Prejudice", "9780141439518", 19),
                new Book("Charlotte Brontë", "Jane Eyre", "9780141441146", 20),
                new Book("Mark Twain", "Adventures of Huckleberry Finn", "9780142437179", 21),
                new Book("John Steinbeck", "Of Mice and Men", "9780140177398", 22),
                new Book("William Golding", "Lord of the Flies", "9780571056866", 23),
                new Book("Mary Shelley", "Frankenstein", "9780486282114", 24),
                new Book("Bram Stoker", "Dracula", "9780141439846", 25),
                new Book("Oscar Wilde", "The Picture of Dorian Gray", "9780141439570", 26),
                new Book("Victor Hugo", "Les Misérables", "9780451419439", 27),
                new Book("Alexandre Dumas", "The Count of Monte Cristo", "9780140449266", 28),
                new Book("Homer", "The Odyssey", "9780140268867", 29),
                new Book("Homer", "The Iliad", "9780140275360", 30),
                new Book("Dante Alighieri", "Inferno", "9780142437223", 31),
                new Book("Miguel de Cervantes", "Don Quixote", "9780060934347", 32),
                new Book("Gabriel García Márquez", "One Hundred Years of Solitude", "9780060883287", 33),
                new Book("Paulo Coelho", "The Alchemist", "9780062315007", 34),
                new Book("Antoine de Saint-Exupéry", "The Little Prince", "9780156012195", 35),
                new Book("Douglas Adams", "The Hitchhiker's Guide to the Galaxy", "9780345391803", 36),
                new Book("Frank Herbert", "Dune", "9780441172719", 37),
                new Book("Isaac Asimov", "Foundation", "9780553293357", 38),
                new Book("Arthur C. Clarke", "2001: A Space Odyssey", "9780451450525", 39),
                new Book("Philip K. Dick", "Do Androids Dream of Electric Sheep?", "9780345404473", 40),
                new Book("Agatha Christie", "Murder on the Orient Express", "9780062693662", 41),
                new Book("Arthur Conan Doyle", "The Hound of the Baskervilles", "9780553328252", 42),
                new Book("Stephen King", "It", "9781501142970", 43),
                new Book("Neil Gaiman", "American Gods", "9780380973651", 44),
                new Book("Suzanne Collins", "The Hunger Games", "9780439023481", 45),
                new Book("Veronica Roth", "Divergent", "9780062024039", 46),
                new Book("Khaled Hosseini", "The Kite Runner", "9781594631931", 47),
                new Book("Cormac McCarthy", "The Road", "9780307387899", 48),
                new Book("Ernest Hemingway", "A Farewell to Arms", "9780099273963", 49),
                new Book("Albert Camus", "The Stranger", "9780679720201", 50)
        );
    }

    public static List<Member> getMembers(){
        return List.of(
                new Member("Jens Jensen", 111),
                new Member("Karl Karlsen", 222),
                new Member("Nikolai Nikolaisen", 333),
                new Member("Peter Petersen", 444),
                new Member("Anders Andersen", 555)
        );
    }
}