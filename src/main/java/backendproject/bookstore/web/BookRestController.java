package backendproject.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import backendproject.bookstore.domain.Book;
import backendproject.bookstore.domain.BookRepository;


@Controller
@RequestMapping("/rest")
public class BookRestController {

    private BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public @ResponseBody List<Book> findAllBooksRest(){
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> getOneBookRest(@PathVariable(name = "id") Long bookId){
        return bookRepository.findById(bookId);
    }

}
