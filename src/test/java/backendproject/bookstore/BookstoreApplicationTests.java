package backendproject.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import backendproject.bookstore.web.BookController;
import backendproject.bookstore.web.CategoryController;
import backendproject.bookstore.web.BookRestController;

@SpringBootTest
class BookstoreApplicationTests {

    @Autowired
    private BookController bookController;
    @Autowired
    private CategoryController categoryController;
    @Autowired
    private BookRestController bookRestController;

	@Test
    public void contexLoads() throws Exception {
        assertThat(bookController).isNotNull();
        assertThat(categoryController).isNotNull();
        assertThat(bookRestController).isNotNull();
    }
}