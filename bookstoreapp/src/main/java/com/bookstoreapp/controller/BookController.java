package com.bookstoreapp.controller;

import com.bookstoreapp.model.Book;
import com.bookstoreapp.model.Author;
import com.bookstoreapp.model.Genre;
import com.bookstoreapp.model.Publisher;
import com.bookstoreapp.repository.BookRepository;
import com.bookstoreapp.repository.AuthorRepository;
import com.bookstoreapp.repository.GenreRepository;
import com.bookstoreapp.repository.PublisherRepository;
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
    //creating an instance of the book repo
    private BookService bookService;
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private GenreRepository genreRepository;
    private PublisherRepository publisherRepository;

    //autowiring --> you to inject the object dependency implicitly
    @Autowired
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) { this.authorRepository = authorRepository;
    }

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    @Autowired
    public void setPublisherRepository(PublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }


    @Autowired
    public void setBookService(BookService bookService) { this.bookService = bookService; }
    //create the four endpoints

    //1 -> GET all books  http://localhost:9092/api/books/
    @GetMapping("/books")
    public List<Book> getBooks(){
       LOGGER.info(" calling getBooks method from controller");
        return bookService.getBooks();
    }

    //2 -> Get one book http://localhost:9092/api/books/1
    @GetMapping("/books/{bookId}")
    public Optional getBook(@PathVariable Long bookId) {
        LOGGER.info(" calling getBook method from controller");
        return bookService.getBook(bookId);
    }

//postman??
    //3 -> CREATE a book  http://localhost:9092/api/books/
    @PostMapping(path="/books/")
      public Book createBook(@RequestBody Book bookObject) {
        LOGGER.info("calling createBook method from controller ");
        return bookService.createBook(bookObject);
    }



    //4 - > UPDATE a book  http://localhost:9092/api/books/1
    @PutMapping(path = "/books/{bookId}")
    public Book updateBook(@PathVariable(
            value = "bookId") Long bookId, @RequestBody Book bookObject) {
        LOGGER.info("calling updateBook method from controller");
        return bookService.updateBook(bookId, bookObject);
    }



//    //5 - > DELETE a book  http://localhost:9092/api/books/1
    @DeleteMapping(path = "/books/{bookId}")
     public Optional<Book> deleteBook(@PathVariable(value = "bookId") Long bookId) {
        LOGGER.info("calling deleteBook method from controller");
        return bookService.deleteBook(bookId);
    }


//===========================================Author================================================================


// get all authors
    @GetMapping("/authors")
    public List<Author> getAuthors() {
        LOGGER.info(" calling getAuthors method from controller");
        return bookService.getAuthors();
    }
// get a single author
    @GetMapping("/authors/{authorId}")
    public Optional getAuthor(@PathVariable Long authorId) {
        LOGGER.info(" calling getAuthor method from controller");
    return bookService.getAuthor(authorId);
}

// create a single author
    @PostMapping(path="/authors/")
    public Author createAuthor(@RequestBody Author authorObject) {
        LOGGER.info("calling createAuthor method from controller");
    return bookService.createAuthor(authorObject);
}

// update an author  http://localhost:9092/api/authors/1

    @PutMapping(path = "/authors/{authorId}")
    public Author updateAuthor(@PathVariable(
            value = "authorId") Long authorId, @RequestBody Author authorObject) {
        LOGGER.info("calling updateAuthor method from controller");
        return bookService.updateAuthor(authorId, authorObject);
    }


    //  DELETE a author  http://localhost:9092/api/books/1
    @DeleteMapping(path = "/authors/{authorId}")
    public Optional<Author> deleteAuthor(@PathVariable(value = "authorId") Long authorId) {
        LOGGER.info("calling deleteAuthor method from controller");
        return bookService.deleteAuthor(authorId);
    }




//===========================================Genre================================================================

//// get all genres
    @GetMapping("/genres")
    public List<Genre> getGenres() {
        LOGGER.info(" calling getGenres method from controller");
        return bookService.getGenres();
    }
    // get a single genre
    @GetMapping("/genres/{genreId}")
    public Optional getGenre(@PathVariable Long genreId) {
        LOGGER.info(" calling getGenre method from controller");
        return bookService.getGenre(genreId);
    }

    // create a single genre
    @PostMapping(path="/genres/")
    public Genre createGenre(@RequestBody Genre genreObject) {
        LOGGER.info("calling createGenre method from controller");
        return bookService.createGenre(genreObject);
    }

// update an author  http://localhost:9092/api/genres/1

    @PutMapping(path = "/genres/{genreId}")
    public Genre updateGenre(@PathVariable(
            value = "genreId") Long genreId, @RequestBody Genre genreObject) {
        LOGGER.info("calling updateGenre method from controller");
        return bookService.updateGenre(genreId, genreObject);
    }


    //  DELETE a author  http://localhost:9092/api/genres/1
    @DeleteMapping(path = "/genres/{genreId}")
    public Optional<Genre> deleteGenre(@PathVariable(value = "genreId") Long genreId) {
        LOGGER.info("calling deleteGenre method from controller");
        return bookService.deleteGenre(genreId);
    }

    // get author by book /author/{authorId}books
    @GetMapping("/authors/{authorId}/books")
    public List<Author> getAuthorBooks(@PathVariable(value = "authorId") Long authorId) {
        LOGGER.info("calling getAuthorBooks method from controller");
        return bookService.getAuthorBooks(authorId);

    }
//    @GetMapping("/authors/{authorId}/books/{bookId}")
//    public Book getAuthorBook(
//            @PathVariable(value = "authorId") Long authorId, @PathVariable(value = "bookId") Long bookId) {
//       LOGGER.info("calling getAuthorbook method from controller");
//        return bookService.getAuthorBook(authorId, bookId);
//    }


    // get author by genre /author/{authorId}genres
    @GetMapping("/authors/{authorId}/genres")
    public List<Author> getAuthorGenres(@PathVariable(value = "authorId") Long authorId) {
        LOGGER.info("calling getAuthorGenres method from controller");
        return bookService.getAuthorGenres(authorId);
    }
    // get author by genre /author/{authorId}publishers
    @GetMapping("/authors/{authorId}/publishers")
    public List<Author> getAuthorPublishers(@PathVariable(value = "authorId") Long authorId) {
        LOGGER.info("calling getAuthorPublishers method from controller");
        return bookService.getAuthorPublishers(authorId);

    }
//    GET	/api/categories/{categoryId}/recipes
//    POST	/api/categories/{categoryId}/recipes
//    GET	/api/categories/{categoryId}/recipes/{recipeId}
//    PUT	/api/categories/{categoryId}/recipes/{recipeId}
//    DELETE	/api/categories/{categoryId}/recipes/{recipeId}

    //============================================Publisher================================================================
// get all publisher
@GetMapping("/publishers")
public List<Publisher> getPublishers() {
    LOGGER.info(" calling getPublishers method from controller");
    return bookService.getPublishers();
}
 //    get a single publisher
    @GetMapping("/publishers/{publisherId}")
    public Optional getPublisher(@PathVariable Long publisherId) {
        LOGGER.info(" calling getPublisher method from controller");
        return bookService.getPublisher(publisherId);
    }

    // create a single publisher http://localhost:9092/api/publishers/1
    @PostMapping(path="/publishers/")
    public Publisher createPublisher(@RequestBody Publisher publisherObject) {
        LOGGER.info("calling createPublisher method from controller");
        return bookService.createPublisher(publisherObject);
    }

// update an author http://localhost:9092/api/publishers/1

    @PutMapping(path = "/publishers/{publisherId}")
    public Publisher updatePublisher(@PathVariable(
            value = "publisherId") Long publisherId, @RequestBody Publisher publisherObject) {
        LOGGER.info("calling updatePublisher method from controller");
        return bookService.updatePublisher(publisherId, publisherObject);
    }


    //  DELETE a author  http://localhost:9092/api/publishers/1
    @DeleteMapping(path = "/publishers/{publisherId}")
    public Optional<Publisher> deletePublisher(@PathVariable(value = "publisherId") Long publisherId) {
        LOGGER.info("calling deletePublisher method from controller");
        return bookService.deletePublisher(publisherId);
    }



}
//1 -> GET all books by an author http://localhost:9092/api/books/{bookId}/authors
//    @GetMapping("/books/{bookId}/authors")
//    public List<Author> getBookAuthors(@PathVariable(value = "bookId") Long bookId) {
//        LOGGER.info(" calling getBookAuthors method from controller");
//        return bookService.getBookAuthors(bookId);
//    }




