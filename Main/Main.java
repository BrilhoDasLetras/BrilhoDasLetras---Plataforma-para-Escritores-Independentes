import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.run();
    }
}

class MainMenu {
    private LibraryManager libraryManager;
    private Scanner scanner;

    public MainMenu() {
        libraryManager = new LibraryManager();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nBem-vindo à Brilho das Letras Library!");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Registrar um novo leitor");
            System.out.println("2. Registrar um novo escritor");
            System.out.println("3. Visualizar o perfil de um leitor");
            System.out.println("4. Visualizar o perfil de um escritor");
            System.out.println("5. Visualizar todos os livros publicados");
            System.out.println("6. Registrar um novo livro (apenas para escritores)");
            System.out.println("7. Realizar uma transação (compra ou apoio)");
            System.out.println("8. Sair do sistema");

            int choice = getIntInput("Escolha uma opção: ");

            switch (choice) {
                case 1:
                    registerNewReader();
                    break;
                case 2:
                    registerNewWriter();
                    break;
                case 3:
                    viewReaderProfile();
                    break;
                case 4:
                    viewWriterProfile();
                    break;
                case 5:
                    viewAllBooks();
                    break;
                case 6:
                    registerNewBook();
                    break;
                case 7:
                    performTransaction();
                    break;
                case 8:
                    exit = true;
                    System.out.println("Saindo do sistema. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }

        scanner.close();
    }

    private int getIntInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private String getStringInput(String prompt) {
        scanner.nextLine(); // Consumir a nova linha pendente
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private void registerNewReader() {
        String name = getStringInput("Nome do leitor: ");
        String dateOfBirth = getStringInput("Data de nascimento: ");
        String email = getStringInput("Email: ");
        String username = getStringInput("Nome de usuário: ");
        String password = getStringInput("Senha: ");
        String biography = getStringInput("Biografia (opcional): ");

        Reader reader = new Reader(name, dateOfBirth, email, username, password, biography);
        libraryManager.registerReader(reader);
        System.out.println("Leitor registrado com sucesso!");
    }

    private void registerNewWriter() {
        String name = getStringInput("Nome do escritor: ");
        String dateOfBirth = getStringInput("Data de nascimento: ");
        String email = getStringInput("Email: ");
        String username = getStringInput("Nome de usuário: ");
        String password = getStringInput("Senha: ");
        String biography = getStringInput("Biografia (opcional): ");

        Writer writer = new Writer(name, dateOfBirth, email, username, password, biography);
        libraryManager.registerWriter(writer);
        System.out.println("Escritor registrado com sucesso!");
    }

    private void viewReaderProfile() {
        String username = getStringInput("Nome de usuário do leitor: ");
        Reader reader = libraryManager.findReaderByUsername(username);

        if (reader != null) {
            System.out.println("Perfil do Leitor:");
            System.out.println(reader);
        } else {
            System.out.println("Leitor não encontrado.");
        }
    }

    private void viewWriterProfile() {
        String username = getStringInput("Nome de usuário do escritor: ");
        Writer writer = libraryManager.findWriterByUsername(username);

        if (writer != null) {
            System.out.println("Perfil do Escritor:");
            System.out.println(writer);
        } else {
            System.out.println("Escritor não encontrado.");
        }
    }

    private void viewAllBooks() {
        List<Book> books = libraryManager.getAllBooks();

        if (books.isEmpty()) {
            System.out.println("Nenhum livro publicado ainda.");
        } else {
            System.out.println("Livros Publicados:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void registerNewBook() {
        String username = getStringInput("Nome de usuário do escritor: ");
        Writer writer = libraryManager.findWriterByUsername(username);

        if (writer != null) {
            String title = getStringInput("Título do livro: ");
            String description = getStringInput("Descrição: ");
            String genre = getStringInput("Gênero: ");
            int yearPublished = getIntInput("Ano de publicação: ");
            String ISBN = getStringInput("ISBN: ");

            Book book = new Book(title, writer, description, genre, yearPublished, ISBN);
            libraryManager.registerBook(book);
            System.out.println("Livro registrado com sucesso!");
        } else {
            System.out.println("Escritor não encontrado.");
        }
    }

    private void performTransaction() {
        // Implemente a lógica para realizar uma transação (compra ou apoio) aqui
        String username = getStringInput("Nome de usuário do leitor: ");
        Reader reader = libraryManager.findReaderByUsername(username);

        if (reader != null) {
            String bookTitle = getStringInput("Título do livro: ");
            Book book = libraryManager.findBookByTitle(bookTitle);

            if (book != null) {
                double amount = scanner.nextDouble();
                Transaction transaction = new Transaction(reader, book, amount);
                // Faça algo com a transação, como armazenar em uma lista
                System.out.println("Transação realizada com sucesso!");
            } else {
                System.out.println("Livro não encontrado.");
            }
        } else {
            System.out.println("Leitor não encontrado.");
        }
    }
}

class Book {
    private String title;
    private Writer author;
    private String description;
    private String genre;
    private int yearPublished;
    private String ISBN;

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
    
    public void displayBookDetails() {
        System.out.println("Título: " + title);
    }
}

class Writer {
    private String name;
    private String dateOfBirth;
    private String email;
    private String username;
    private String password;
    private List<Book> booksWritten;
    private String biography;

    public Writer(String name, String dateOfBirth, String email, String username, String password, String biography) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.username = username;
        this.password = password;
        this.biography = biography;
        this.booksWritten = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Book> getBooksWritten() {
        return booksWritten;
    }

    public String getBiography() {
        return biography;
    }

    public void addBookWritten(Book book) {
        booksWritten.add(book);
    }

    @Override
    public String toString() {
        return "Writer{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}

class Reader {
    private String name;
    private String dateOfBirth;
    private String email;
    private String username;
    private String password;
    private List<Book> booksRead;
    private String biography;

    public Reader(String name, String dateOfBirth, String email, String username, String password, String biography) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.username = username;
        this.password = password;
        this.biography = biography;
        this.booksRead = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Book> getBooksRead() {
        return booksRead;
    }

    public String getBiography() {
        return biography;
    }

    public void addBookRead(Book book) {
        booksRead.add(book);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}

class LibraryManager {
    private List<Writer> writers;
    private List<Reader> readers;
    private List<Book> books;

    public LibraryManager() {
        this.writers = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.books = new ArrayList<>();
    }

    public void registerWriter(Writer writer) {
        writers.add(writer);
    }

    public void registerReader(Reader reader) {
        readers.add(reader);
    }

    public void registerBook(Book book) {
        books.add(book);
        // Adicione o livro à lista de livros escritos pelo autor
        book.getAuthor().addBookWritten(book);
    }

    public List<Writer> getWriters() {
        return writers;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Reader findReaderByUsername(String username) {
        for (Reader reader : readers) {
            if (reader.getUsername().equals(username)) {
                return reader;
            }
        }
        return null; // Retorna null se não encontrar um leitor com o nome de usuário especificado
    }

    public Writer findWriterByUsername(String username) {
        for (Writer writer : writers) {
            if (writer.getUsername().equals(username)) {
                return writer;
            }
        }
        return null; // Retorna null se não encontrar um escritor com o nome de usuário especificado
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
}

class Transaction {
    private Reader reader;
    private Book book;
    private double amount;
    private Date transactionDate;

    public Transaction(Reader reader, Book book, double amount) {
        this.reader = reader;
        this.book = book;
        this.amount = amount;
        this.transactionDate = new Date();
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }
}

                
                
                
                
                
