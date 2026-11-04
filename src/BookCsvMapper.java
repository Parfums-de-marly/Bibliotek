public class BookCsvMapper {

    public String toCsv(Book book){

        return book.getIdentifier() + "," + book.getTitle() + "," + book.getCreator() + "," + book.getPages();
    }

    public Book fromCsv(String line){
        String[] parts = line.split(",");

        String identifier = parts[0];
        String title = parts[1];
        String creator = parts[2];
        int pages = Integer.parseInt(parts[3]);

        return new Book(identifier,title, creator, pages);

    }
}
