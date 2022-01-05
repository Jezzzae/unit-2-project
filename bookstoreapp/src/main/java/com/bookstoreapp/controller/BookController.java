package com.bookstoreapp.controller;

import com.bookstoreapp.model.Book;

import com.bookstoreapp.repository.BookRepository;
import com.bookstoreapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import java.awt.print.Book;

@RestController
@RequestMapping(path = "/api")
public class BookController {

    //creating an instance of the book repo
    private BookRepository bookRepository;
    private BookService bookService;

    //autowiring --> you to inject the object dependency implicitly
    @Autowired
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setBookService(BookService bookService) { this.bookService = bookService; }
    //create the four endpoints

    //1 -> GET all books  http://localhost:9092/api/books/

    @GetMapping("/books")
    public List<Book> getBook(){
        System.out.println(" calling getBooks ==> ");
        return bookService.getBook();
    }
    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        System.out.println(" calling getBooks ==> ");
        return bookService.getBook(bookId);
    }

    //2 -> CREATE a book  http://localhost:9092/api/books/

    @PostMapping(path="/books/")
//    public com.bookstoreapp.model.Book createBook(@PathVariable (value = "bookId") Long bookId){ //(value = "bookid")
      public Book createBook(@RequestBody Book bookObject) {
        System.out.println("calling createBook ==> ");
        return bookService.createBook(bookObject);
    }



    //3 - > UPDATE a book  http://localhost:9092/api/books/1

    @PutMapping(path = "/books/{bookId}")
    public Book updateBook(@PathVariable(
            value = "bookId") Long bookId, @RequestBody Book bookObject) {
        System.out.println("calling updateBook ==> ");
        return bookService.updateBook(bookId, bookObject);
    }

    //4 - > DELETE a book  http://localhost:9092/api/books/1

    @DeleteMapping(path = "/books/{bookId}")
     public String deleteBook(@PathVariable(value = "bookId") Long bookId) {
        System.out.println("calling deleteBook ==> ");
        return bookService.deleteBook(bookId);
    }

}
