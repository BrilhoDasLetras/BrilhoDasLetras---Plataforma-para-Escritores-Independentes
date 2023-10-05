import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<Writer> writers;
    private List<Reader> readers;

    public LibraryManager() {
        this.writers = new ArrayList<>();
        this.readers = new ArrayList<>();
    }

    public void registerWriter(Writer writer) {
        writers.add(writer);
    }

    public void registerReader(Reader reader) {
        readers.add(reader);
    }

    public List<Writer> getWriters() {
        return writers;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();

        // Exemplo de registro de escritor e leitor
        Writer writer = new Writer("Autor 1", "01/01/1980", "autor1@email.com", "autor1", "senha", "Biografia do Autor");
        Reader reader = new Reader("Leitor 1", "10/05/1995", "leitor1@email.com", "leitor1", "senha", "");

        libraryManager.registerWriter(writer);
        libraryManager.registerReader(reader);

        // Recuperar escritores e leitores registrados
        List<Writer> registeredWriters = libraryManager.getWriters();
        List<Reader> registeredReaders = libraryManager.getReaders();

        // Exibir informações dos escritores e leitores registrados
        System.out.println("Escritores Registrados:");
        for (Writer w : registeredWriters) {
            System.out.println(w);
        }

        System.out.println("\nLeitores Registrados:");
        for (Reader r : registeredReaders) {
            System.out.println(r);
        }
    }
}
