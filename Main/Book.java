public class Book {
    private String title;
    private Writer author;
    private String description;
    private String genre;
    private int yearPublished;
    private String ISBN; // Número de Identificação Internacional de Livro

    public Book(String title, Writer author, String description, String genre, int yearPublished, String ISBN) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public Writer getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author.getName() +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", yearPublished=" + yearPublished +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    // Método para exibir informações detalhadas sobre o livro
    public void displayBookDetails() {
        System.out.println("Título: " + title);
       
