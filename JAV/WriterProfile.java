public class WriterProfile {
    public static void main(String[] args) {
        // Criar um escritor com sua biografia
        Writer writer = new Writer("Autor 1", "01/01/1980", "autor1@email.com", "autor1", "senha",
                "Biografia do Autor");

        // Criar livros escritos pelo autor
        Book book1 = new Book("Livro 1", writer, "Descrição do Livro 1", "Ficção", 2005, "ISBN123456");
        Book book2 = new Book("Livro 2", writer, "Descrição do Livro 2", "Fantasia", 2010, "ISBN789012");

        // Adicionar os livros à lista de livros escritos pelo autor
        writer.addBookWritten(book1);
        writer.addBookWritten(book2);

        // Exibir informações do escritor e suas obras
        System.out.println("Perfil do Escritor:");
        System.out.println(writer);

        System.out.println("\nLivros Escritos pelo Autor:");
        for (Book book : writer.getBooksWritten()) {
            book.displayBookDetails();
            System.out.println();
        }
    }
}
