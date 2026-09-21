package backendproject.bookstore.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import backendproject.bookstore.domain.Book;
import backendproject.bookstore.domain.BookRepository;
import backendproject.bookstore.domain.CategoryRepository;



@Controller
public class BookController {

    private CategoryRepository categoryRepository;

    BookRepository bookRepository;

    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository){
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
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

    @GetMapping("/addbook")
    public String getNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";  //bookform.html
    }

        @GetMapping("/edit/{id}")
        public String editBook(@PathVariable("id") Long bookId, Model model) {
        Book book = bookRepository.findById(bookId).get();
        model.addAttribute("book", book);
        return "addbook";
        }

    @PostMapping("/savebook")
    public String saveBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable ("id") Long bookId) {
        bookRepository.deleteById(bookId);
        return "redirect:/booklist";
    }

}

