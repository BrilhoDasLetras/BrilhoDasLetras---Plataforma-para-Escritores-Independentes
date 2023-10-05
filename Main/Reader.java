import java.util.ArrayList;
import java.util.List;

public class Reader {
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
