package backendproject.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backendproject.bookstore.domain.Book;
import backendproject.bookstore.domain.BookRepository;
import backendproject.bookstore.domain.Category;
import backendproject.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository) {
        return (args) -> {

            // Categories
            Category scifi = new Category("Scifi");
            Category fantasy = new Category("Fantasy");
            Category children = new Category("Children");

            categoryRepository.save(scifi);
            categoryRepository.save(fantasy);
            categoryRepository.save(children);

            //books
            Book a = new Book(
                    "Narnia",
                    "C.S.Lewis",
                    "1955",
                    "951-1-20526-9",
                    39.50f);

            a.setCategory(fantasy);
            repository.save(a);

        };
    }
}