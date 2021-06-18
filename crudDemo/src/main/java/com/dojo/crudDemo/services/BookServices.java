package com.dojo.crudDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.crudDemo.models.Book;
import com.dojo.crudDemo.repositories.BookRepository;
@Service
public class BookServices {
	// adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
        
    }
    public  void deleteBook(Long id) {
    	this.bookRepository.deleteById(id);
    }
    public  Book getBook(Long id) {
    	Optional<Book> optionalBook=this.bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
    		return optionalBook.get();
    	}
    	else {
    		return null;
    	}
    	
    }
    public Book updateBook(Long id,String title,String description,String language,Integer numberOfPages) {
    	Book toUpdateBook = this.bookRepository.findById(id).orElseGet(null);
    	if (toUpdateBook==null) {
			return null;
		}
    	else {
    		toUpdateBook.setTitle(title);
    		toUpdateBook.setDescription(description);
    		toUpdateBook.setLanguage(language);
    		toUpdateBook.setNumberOfPages(numberOfPages);
    		return this.bookRepository.save(toUpdateBook);
    	}
    }
    public  Book updateBook( Book book) {
    	return this.bookRepository.save(book);
    }
}
