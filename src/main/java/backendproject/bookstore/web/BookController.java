package backendproject.bookstore.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import backendproject.bookstore.domain.Book;
import backendproject.bookstore.domain.BookRepository;



@Controller
public class BookController {

    BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/index")
    public String bookController() {
        return "frontpage"; // frontpage.html
    }

    @GetMapping("/booklist")
    public String bookController(Model model) {
        List<Book> books =(List<Book>) bookRepository.findAll();
        model.addAttribute("books", books);
        return "booklist";
    }
}
