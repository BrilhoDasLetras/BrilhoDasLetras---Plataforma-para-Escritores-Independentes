public class BookPublication {
    public static void main(String[] args) {
        // Criar livros
        Book book1 = new Book("Livro 1", null, "Descrição do Livro 1", "Ficção", 2005, "ISBN123456");
        Book book2 = new Book("Livro 2", null, "Descrição do Livro 2", "Fantasia", 2010, "ISBN789012");

        // Exibir informações detalhadas sobre os livros
        System.out.println("Informações sobre Obras Literárias:");

        System.out.println("\nLivro 1:");
        book1.displayBookDetails();

        System.out.println("\nLivro 2:");
        book2.displayBookDetails();
    }
}
