package backendproject.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import backendproject.bookstore.domain.Book;
import backendproject.bookstore.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test // save
    public void createNewBook() {
        Book book = new Book("Test Book", "Test Author", "0000", "isbn-test", 20.00f);

        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test // delete
    public void deleteBook() {
        Book book = new Book("Test Book", "Test Author", "0000", "isbn-test", 20.00f);

        Book savedBook = bookRepository.save(book);
        bookRepository.delete(savedBook);
        assertThat(bookRepository.findById(savedBook.getId())).isEmpty();
    }

    @Test // search
    public void findByTitleShouldReturnBook() {
        Book book = new Book();
        book.setTitle("Narnia");
        bookRepository.save(book);

        List<Book> books = bookRepository.findByTitle("Narnia");
        assertThat(books).hasSize(2);
        assertThat(books.get(0).getTitle()).isEqualTo("Narnia");
    }
}