import java.util.Date;

public class Transaction {
    private Reader reader;
    private Book book;
    private double amount;
    private Date transactionDate;

    public Transaction(Reader reader, Book book, double amount) {
        this.reader = reader;
        this.book = book;
        this.amount = amount;
        this.transactionDate = new Date(); // Data da transação atual
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

    public static void main(String[] args) {
        Reader reader = new Reader("Leitor 1", "15/08/1990", "leitor1@email.com", "leitor1", "senha", "");
        Book book1 = new Book("Livro 1", null, "Descrição do Livro 1", "Ficção", 2005, "ISBN123456");

        Transaction purchaseTransaction = new Transaction(reader, book1, 10.99); // Compra do livro
        Transaction supportTransaction = new Transaction(reader, book1, 5.00);   // Apoio (doação) ao autor

        // Exibir informações das transações
        System.out.println("Transação de Compra:");
        System.out.println("Leitor: " + purchaseTransaction.getReader().getName());
        System.out.println("Livro: " + purchaseTransaction.getBook().getTitle());
        System.out.println("Valor: $" + purchaseTransaction.getAmount());
        System.out.println("Data da Transação: " + purchaseTransaction.getTransactionDate());

        System.out.println("\nTransação de Apoio (Doação):");
        System.out.println("Leitor: " + supportTransaction.getReader().getName());
        System.out.println("Livro: " + supportTransaction.getBook().getTitle());
        System.out.println("Valor: $" + supportTransaction.getAmount());
        System.out.println("Data da Transação: " + supportTransaction.getTransactionDate());
    }
}
