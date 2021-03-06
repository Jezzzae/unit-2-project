package com.bookstoreapp.controller;

import com.bookstoreapp.model.Book;
import com.bookstoreapp.model.Author;
import com.bookstoreapp.model.Genre;
import com.bookstoreapp.model.Publisher;
import com.bookstoreapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping(path = "/api")
public class BookController {
    private static final Logger LOGGER = Logger.getLogger(BookController.class.getName());
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
    //creating the four endpoints - (Book, Author, Genre, Publisher)



//==========================================Book==============================================

    //1 -> GET all books http://localhost:9092/api/books
    @GetMapping("/books")
    public List<Book> getBooks() {
        LOGGER.info(" calling getBooks method from controller");

        return bookService.getBooks();
    }

    //2 -> Get one book http://localhost:9092/api/books/1
    @GetMapping("/books/{bookId}")
    public Optional getBook(@PathVariable Long bookId) {
        LOGGER.info(" calling getBook method from controller");
        return bookService.getBook(bookId);
    }


    //3 -> Post/Create a book http://localhost:9092/api/books
    @PostMapping(path = "/books/")
    public Book createBook(@RequestBody Book bookObject) {
        LOGGER.info("calling createBook method from controller ");
        return bookService.createBook(bookObject);
    }


    //4 -> Put/Update a book  http://localhost:9092/api/books/1
    @PutMapping(path = "/books/{bookId}")
    public Book updateBook(@PathVariable(
            value = "bookId") Long bookId, @RequestBody Book bookObject) {
        LOGGER.info("calling updateBook method from controller");
        return bookService.updateBook(bookId, bookObject);
    }


    //5 -> Delete a book http://localhost:9092/api/books/1
    @DeleteMapping(path = "/books/{bookId}")
    public Optional<Book> deleteBook(@PathVariable(value = "bookId") Long bookId) {
        LOGGER.info("calling deleteBook method from controller");
        return bookService.deleteBook(bookId);
    }


//===========================================Author================================================================


    //6 -> Get all authors http://localhost:9092/api/authors
    @GetMapping("/authors")
    public List<Author> getAuthors() {
        LOGGER.info(" calling getAuthors method from controller");
        return bookService.getAuthors();
    }

    //7 -> Get a single author http://localhost:9092/api/authors/{authorId}
    @GetMapping("/authors/{authorId}")
    public Optional getAuthor(@PathVariable Long authorId) {
        LOGGER.info(" calling getAuthor method from controller");
        return bookService.getAuthor(authorId);
    }


    //8 -> Post/Create book and add an author to the book  http://localhost:9092/api/books/1/authors
    @PostMapping(path = "/books/{bookId}/authors")
    public Author createAuthor(@PathVariable Long bookId, @RequestBody Author authorObject) {
        LOGGER.info("calling createAuthor method from controller");
        return bookService.createAuthor(bookId, authorObject);
    }

    //9 -> Put/Update an author http://localhost:9092/api/authors/1

    @PutMapping(path = "/authors/{authorId}")
    public Author updateAuthor(@PathVariable(
            value = "authorId") Long authorId, @RequestBody Author authorObject) {
        LOGGER.info("calling updateAuthor method from controller");
        return bookService.updateAuthor(authorId, authorObject);
    }


    //10 -> Delete a author http://localhost:9092/api/books/1
    @DeleteMapping(path = "/authors/{authorId}")
    public Optional<Author> deleteAuthor(@PathVariable(value = "authorId") Long authorId) {
        LOGGER.info("calling deleteAuthor method from controller");
        return bookService.deleteAuthor(authorId);
    }


//===========================================Genre================================================================

    //11 -> Get all genres http://localhost:9092/api/genres
    @GetMapping("/genres")
    public List<Genre> getGenres() {
        LOGGER.info(" calling getGenres method from controller");
        return bookService.getGenres();
    }

    //12 -> Get a single genre http://localhost:9092/api/genres/{genresId}
    @GetMapping("/genres/{genreId}")
    public Optional getGenre(@PathVariable Long genreId) {
        LOGGER.info(" calling getGenre method from controller");
        return bookService.getGenre(genreId);
    }


    //13 -> Post/Create a book and add a genre http://localhost:9092/api/books/1/genres
    @PostMapping(path = "/books/{bookId}/genres")
    public Genre createGenre(@PathVariable Long bookId, @RequestBody Genre genreObject) {
        LOGGER.info("calling createGenre method from controller");
        return bookService.createGenre(bookId, genreObject);
    }


    //14 -> Put/Update an genre http://localhost:9092/api/genres/1

    @PutMapping(path = "/genres/{genreId}")
    public Genre updateGenre(@PathVariable(
            value = "genreId") Long genreId, @RequestBody Genre genreObject) {
        LOGGER.info("calling updateGenre method from controller");
        return bookService.updateGenre(genreId, genreObject);
    }


    //15 -> Delete a genre  http://localhost:9092/api/genres/1
    @DeleteMapping(path = "/genres/{genreId}")
    public Optional<Genre> deleteGenre(@PathVariable(value = "genreId") Long genreId) {
        LOGGER.info("calling deleteGenre method from controller");
        return bookService.deleteGenre(genreId);
    }

    //============================================Publisher=========================================================

    //16 -> Get all publisher http://localhost:9092/api/publishers
    @GetMapping("/publishers")
    public List<Publisher> getPublishers() {
        LOGGER.info(" calling getPublishers method from controller");
        return bookService.getPublishers();
    }

    //17 -> Get a single publisher http://localhost:9092/api/genres/{publisherId}
    @GetMapping("/publishers/{publisherId}")
    public Optional getPublisher(@PathVariable Long publisherId) {
        LOGGER.info(" calling getPublisher method from controller");
        return bookService.getPublisher(publisherId);
    }

    //18 -> Post/Create a book and add a publisher http://localhost:9092/api/books/{bookId}/publishers
    @PostMapping(path = "/books/{bookId}/publishers")
    public Publisher createPublisher(@PathVariable Long bookId, @RequestBody Publisher publisherObject) {
        LOGGER.info("calling createPublisher method from controller");
        return bookService.createPublisher(bookId, publisherObject);
    }


    //19 -> Put/Update a publisher http://localhost:9092/api/publishers/1

    @PutMapping(path = "/publishers/{publisherId}")
    public Publisher updatePublisher(@PathVariable(
            value = "publisherId") Long publisherId, @RequestBody Publisher publisherObject) {
        LOGGER.info("calling updatePublisher method from controller");
        return bookService.updatePublisher(publisherId, publisherObject);
    }


    //20 -> Delete a publisher http://localhost:9092/api/publishers/1
    @DeleteMapping(path = "/publishers/{publisherId}")
    public Optional<Publisher> deletePublisher(@PathVariable(value = "publisherId") Long publisherId) {
        LOGGER.info("calling deletePublisher method from controller");
        return bookService.deletePublisher(publisherId);
    }


}



