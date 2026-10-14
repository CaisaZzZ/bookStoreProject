package backendproject.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backendproject.bookstore.domain.AppUser;
import backendproject.bookstore.domain.AppUserRepository;
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
    public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository,
            AppUserRepository appUserRepository) {
        return (args) -> {

            // Categories
            Category scifi = new Category("Scifi");
            Category fantasy = new Category("Fantasy");
            Category children = new Category("Children");

            categoryRepository.save(scifi);
            categoryRepository.save(fantasy);
            categoryRepository.save(children);

            // books
            Book a = new Book(
                    "Narnia",
                    "C.S.Lewis",
                    "1955",
                    "951-1-20526-9",
                    39.50f);

            Book b = new Book(
                    "Taru Sormusten Herrasta",
                    "J.R.R.Tolkien",
                    "1954",
                    "951-0-13208-X",
                    39.95f);

            a.setCategory(children);
            b.setCategory(fantasy);

            repository.save(a);
            repository.save(b);

            // new user
            AppUser user1 = new AppUser("user", "$2a$10$vuV5Bn/nBEEGAyA5.0eJaOOo0YpeYiRPqr0g8jUxl6q7n6aM5V5Py", "user@email.com", "USER");
            AppUser user2 = new AppUser("admin", "$2a$10$cH.5U5bq5wftK4J.UIRdVeiaYY/UKbSSoys6JIYDaJvdQcMzo3z5C", "admin@email.com", "ADMIN");

            appUserRepository.save(user1);
            appUserRepository.save(user2);

        };
    }

}