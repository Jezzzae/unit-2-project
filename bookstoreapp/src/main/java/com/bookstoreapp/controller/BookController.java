package com.bookstoreapp.controller;

import com.bookstoreapp.repository.BookRepository;
import com.bookstoreapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@RestController
@RequestMapping(path = "/api")
public class BookController {

    //creating an instance of the book repo
    private BookRepository bookRepository;

    //autowiring --> you to inject the object dependency implicitly
    @Autowired
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //create the four endpoints

    //1 -> GET all books  http://localhost:9092/api/books/

    @GetMapping("/books")
    public Book getBook(){
        System.out.println(" calling getBooks ==> ");
        return BookService.getBook();
    }

    //2 -> CREATE a book  http://localhost:9092/api/books/

    @PostMapping(path="/books{bookid}")
    public Book createBook(@PathVariable (value = "bookid") Long bookid){ //(value = "bookid")
        System.out.println("calling createBook ==> ");
        return BookService.createBook(bookid);
    }

    //3 - > UPDATE a book  http://localhost:9092/api/books/1

    @PutMapping(path = "/books{bookid")
    public Book updateBook(@PathVariable (value = "bookid") Long bookid){
        System.out.println("calling updateBook ==> ");
        return BookService.updateBook(bookid);
    }

    //4 - > DELETE a book  http://localhost:9092/api/books/1

    @DeleteMapping(path = "/books/bookid")
        public Book deleteBook(@PathVariable Long bookid){
        System.out.println("calling deleteBook ==> ");
        return BookService.deleteBook(bookid);
    }

}
