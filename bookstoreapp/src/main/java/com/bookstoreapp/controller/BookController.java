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

@RestController
@RequestMapping(path = "/api")
public class BookController {

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
//
//    @Autowired
//    public void setPublisherRepository(publisherRepository publisherRepository){
//        this.publisherRepository = publisherRepository;
//    }


    @Autowired
    public void setBookService(BookService bookService) { this.bookService = bookService; }
    //create the four endpoints

    //1 -> GET all books  http://localhost:9092/api/books/
    @GetMapping("/books")
    public List<Book> getBooks(){
        System.out.println(" calling getBooks ==> ");
        return bookService.getBooks();
    }

    //2 -> Get one book http://localhost:9092/api/books/1
    @GetMapping("/books/{bookId}")
    public Optional getBook(@PathVariable Long bookId) {
        System.out.println(" calling getBook ==> ");
        return bookService.getBook(bookId);
    }

//postman??
    //3 -> CREATE a book  http://localhost:9092/api/books/
    @PostMapping(path="/books/")
      public Book createBook(@RequestBody Book bookObject) {
        System.out.println("calling createBook ==> ");
        return bookService.createBook(bookObject);
    }



    //4 - > UPDATE a book  http://localhost:9092/api/books/1
    @PutMapping(path = "/books/{bookId}")
    public Book updateBook(@PathVariable(
            value = "bookId") Long bookId, @RequestBody Book bookObject) {
        System.out.println("calling updateBook ==> ");
        return bookService.updateBook(bookId, bookObject);
    }



//    //5 - > DELETE a book  http://localhost:9092/api/books/1
    @DeleteMapping(path = "/books/{bookId}")
     public Optional<Book> deleteBook(@PathVariable(value = "bookId") Long bookId) {
        System.out.println("calling deleteBook ==> ");
        return bookService.deleteBook(bookId);
    }


//===========================================Author================================================================


// get all authors
    @GetMapping("/authors")
    public List<Author> getAuthors() {
        System.out.println(" calling getAuthors ==> ");
        return bookService.getAuthors();
    }
// get a single author
    @GetMapping("/authors/{authorId}")
    public Optional getAuthor(@PathVariable Long authorId) {
    System.out.println(" calling getAuthor ==> ");
    return bookService.getAuthor(authorId);
}

// create a single author
    @PostMapping(path="/authors/")
    public Author createAuthor(@RequestBody Author authorObject) {
    System.out.println("calling createAuthor ==> ");
    return bookService.createAuthor(authorObject);
}

// update an author  http://localhost:9092/api/authors/1

    @PutMapping(path = "/authors/{authorId}")
    public Author updateAuthor(@PathVariable(
            value = "authorId") Long authorId, @RequestBody Author authorObject) {
        System.out.println("calling updateAuthor ==> ");
        return bookService.updateAuthor(authorId, authorObject);
    }


    //  DELETE a author  http://localhost:9092/api/books/1
    @DeleteMapping(path = "/authors/{authorId}")
    public Optional<Author> deleteAuthor(@PathVariable(value = "authorId") Long authorId) {
        System.out.println("calling deleteAuthor ==> ");
        return bookService.deleteAuthor(authorId);
    }




//===========================================Genre================================================================

//// get all genres
    @GetMapping("/genres")
    public List<Genre> getGenres() {
        System.out.println(" calling getGenres ==> ");
        return bookService.getGenres();
    }
    // get a single genre
    @GetMapping("/genres/{genreId}")
    public Optional getGenre(@PathVariable Long genreId) {
        System.out.println(" calling getGenre ==> ");
        return bookService.getGenre(genreId);
    }

    // create a single genre
    @PostMapping(path="/genres/")
    public Genre createGenre(@RequestBody Genre genreObject) {
        System.out.println("calling createGenre ==> ");
        return bookService.createGenre(genreObject);
    }

// update an author  http://localhost:9092/api/genres/1

    @PutMapping(path = "/genres/{genreId}")
    public Genre updateGenre(@PathVariable(
            value = "genreId") Long genreId, @RequestBody Genre genreObject) {
        System.out.println("calling updateGenre ==> ");
        return bookService.updateGenre(genreId, genreObject);
    }


    //  DELETE a author  http://localhost:9092/api/genres/1
    @DeleteMapping(path = "/genres/{genreId}")
    public Optional<Genre> deleteGenre(@PathVariable(value = "genreId") Long genreId) {
        System.out.println("calling deleteGenre ==> ");
        return bookService.deleteGenre(genreId);
    }

    // get author by book /author/{authorId}books
    @GetMapping("/authors/{authorId}/books")
    public List<Author> getAuthorBooks(@PathVariable(value = "authorId") Long authorId) {
        System.out.println("calling getAuthorBooks ==> ");
        return bookService.getAuthorBooks(authorId);

    }
//    @GetMapping("/authors/{authorId}/books/{bookId}")
//    public Book getAuthorBook(
//            @PathVariable(value = "authorId") Long authorId, @PathVariable(value = "bookId") Long bookId) {
//        System.out.println("calling getAuthorbook ==>");
//        return bookService.getAuthorBook(authorId, bookId);
//    }


    // get author by genre /author/{authorId}genres
    @GetMapping("/authors/{authorId}/genres")
    public List<Author> getAuthorGenres(@PathVariable(value = "authorId") Long authorId) {
        System.out.println("calling getAuthorGenres ==> ");
        return bookService.getAuthorGenres(authorId);
    }
    // get author by genre /author/{authorId}publishers
    @GetMapping("/authors/{authorId}/publishers")
    public List<Author> getAuthorPublishers(@PathVariable(value = "authorId") Long authorId) {
        System.out.println("calling getAuthorPublishers ==> ");
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
    System.out.println(" calling getPublishers ==> ");
    return bookService.getPublishers();
}
 //    get a single publisher
    @GetMapping("/publishers/{publisherId}")
    public Optional getPublisher(@PathVariable Long publisherId) {
        System.out.println(" calling getPublisher ==> ");
        return bookService.getPublisher(publisherId);
    }

    // create a single publisher http://localhost:9092/api/publishers/1
    @PostMapping(path="/publishers/")
    public Publisher createPublisher(@RequestBody Publisher publisherObject) {
        System.out.println("calling createPublisher ==> ");
        return bookService.createPublisher(publisherObject);
    }

// update an author http://localhost:9092/api/publishers/1

    @PutMapping(path = "/publishers/{publisherId}")
    public Publisher updatePublisher(@PathVariable(
            value = "publisherId") Long publisherId, @RequestBody Publisher publisherObject) {
        System.out.println("calling updatePublisher ==> ");
        return bookService.updatePublisher(publisherId, publisherObject);
    }


    //  DELETE a author  http://localhost:9092/api/publishers/1
    @DeleteMapping(path = "/publishers/{publisherId}")
    public Optional<Publisher> deletePublisher(@PathVariable(value = "publisherId") Long publisherId) {
        System.out.println("calling deletePublisher ==> ");
        return bookService.deletePublisher(publisherId);
    }



}
//1 -> GET all books by an author http://localhost:9092/api/books/{bookId}/authors
//    @GetMapping("/books/{bookId}/authors")
//    public List<Author> getBookAuthors(@PathVariable(value = "bookId") Long bookId) {
//        System.out.println(" calling getBookAuthors ==> ");
//        return bookService.getBookAuthors(bookId);
//    }




