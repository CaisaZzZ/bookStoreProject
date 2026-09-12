package backendproject.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backendproject.bookstore.domain.Book;
import backendproject.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            Book a = new Book(
                "Narnia",
                "C.S.Lewis",
                "1955",
                "951-1-20526-9",
                39.50f);

                repository.save(a);
        };
    }


}
