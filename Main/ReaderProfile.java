public class ReaderProfile {
    public static void main(String[] args) {
        // Criar um leitor com informações pessoais
        Reader reader = new Reader("Leitor 1", "15/08/1990", "leitor1@email.com", "leitor1", "senha",
                "Biografia do Leitor");

        // Criar livros lidos pelo leitor
        Book book1 = new Book("Livro 1", null, "Descrição do Livro 1", "Ficção", 2005, "ISBN123456");
        Book book2 = new Book("Livro 2", null, "Descrição do Livro 2", "Fantasia", 2010, "ISBN789012");

        // Adicionar os livros à lista de livros lidos pelo leitor
        reader.addBookRead(book1);
        reader.addBookRead(book2);

        // Exibir informações do leitor e os livros que leu
        System.out.println("Perfil do Leitor:");
        System.out.println(reader);

        System.out.println("\nLivros Lidos pelo Leitor:");
        for (Book book : reader.getBooksRead()) {
            book.displayBookDetails();
            System.out.println();
        }
    }
}
