package com.dojo.crudDemo;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.crudDemo.models.Book;
import com.dojo.crudDemo.services.BookServices;
@Controller
//@RestController
public class HomeController {
	
    private final BookServices bookService;
    public HomeController(BookServices bookService){
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
    @RequestMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "new.jsp";
    }
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    @RequestMapping(value="/delete/{id}")
    	public String delete(@PathVariable("id") Long id) {
    		this.bookService.deleteBook(id);
    		return "redirect:/books";
    	}
    

    
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
    @GetMapping("/view/{id}")
    public String viewBook(@PathVariable("id")Long id,Model model) {
    	Book bookToShow = this.bookService.getBook(id);
    	model.addAttribute("thisBook",bookToShow);
    	return "onBook.jsp";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id")Long id,@ModelAttribute("book") Book book,Model model) {
    	Book bookToShow = this.bookService.getBook(id);
    	model.addAttribute("thisBook",bookToShow);
    	return "update.jsp";
    }

    @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "update.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
    
}
