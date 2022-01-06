package com.bookstoreapp.service;


import com.bookstoreapp.controller.BookController;
import com.bookstoreapp.exception.InformationExistException;
import com.bookstoreapp.exception.InformationNotFoundException;
import com.bookstoreapp.model.Author;
import com.bookstoreapp.model.Book;
import com.bookstoreapp.model.Genre;
import com.bookstoreapp.model.Publisher;
import com.bookstoreapp.repository.AuthorRepository;
import com.bookstoreapp.repository.BookRepository;
import com.bookstoreapp.repository.GenreRepository;
import com.bookstoreapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class BookService {
    private static final Logger LOGGER = Logger.getLogger(BookController.class.getName());

    private BookRepository bookRepository;


    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private AuthorRepository authorRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }

    private GenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository) {

        this.genreRepository = genreRepository;
    }

    private PublisherRepository publisherRepository;

    @Autowired
    public void setPublisherRepository(PublisherRepository publisherRepository) {

        this.publisherRepository = publisherRepository;
    }

    // ===============================================Book=========================================================
    //1 -> GET all books  http://localhost:9092/api/books/
    public List<Book> getBooks() {
        LOGGER.info("service calling getBook==>");
        return bookRepository.findAll();
    }

    //2 -> Get one book http://localhost:9092/api/books/1
    public Optional getBook(Long bookId) {
        LOGGER.info("service calling getBook==>");
        Optional book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            return book;
        } else {
            throw new InformationNotFoundException("book with id " + bookId + " not found");
        }
    }

    //3 -> CREATE a book  http://localhost:9092/api/books/
    public Book createBook(Book bookObject) {
        LOGGER.info("service calling createBook ==>");
        Book book = bookRepository.findByTitle(bookObject.getTitle());
        if (book != null) {
            throw new InformationExistException("book with name " + book.getTitle() + " already exists");
        } else {
            return bookRepository.save(bookObject);
//
        }
    }

    //4 - > UPDATE a book  http://localhost:9092/api/books/1
    public Book updateBook(Long bookId, Book bookObject) {
        LOGGER.info("service calling updateBook method ==> ");
        Optional<Book> book = bookRepository.findById(bookId);
        if (book == null) {
            throw new InformationNotFoundException("book with id " + bookId + " not found");


        } else {
            book.get().setTitle(bookObject.getTitle());
            return bookRepository.save(book.get());

        }

    }

    //5 - > DELETE a book  http://localhost:9092/api/books/1
    public Optional<Book> deleteBook(Long bookId) {
        LOGGER.info("calling deleteBook method ==>");
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            bookRepository.deleteById(bookId);
            return book;
        } else {
            throw new InformationNotFoundException("book with id: " + bookId + " not found");
        }
    }


    ////  BookBy...


    // ===============================================AUTHOR=========================================================
// get all authors http://localhost:9092/api/authors/
    public List<Author> getAuthors() {
        LOGGER.info("service calling getBook==>");
        return authorRepository.findAll();
    }

    // get a single author http://localhost:9092/api/authors/1
    public Optional getAuthor(Long authorId) {
        LOGGER.info("service calling getAuthor==>");
        Optional author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            return author;
        } else {
            throw new InformationNotFoundException("author with id " + authorId + " not found");
        }
    }

    // http://localhost:9092/api/books/1/authors
    public Author createAuthor(Long bookId, Author authorObject) {
        LOGGER.info("service calling createAuthor ==>");
        try {
            // here we're trying to find the book
            Optional book = bookRepository.findById(bookId);
            // if the book is found, then attach it to the authorObject
            authorObject.setBook((Book) book.get());
            // we save the author with the book information
            return authorRepository.save(authorObject);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("Book with id " + bookId + "not found");
        }
    }

    //   UPDATE author  http://localhost:9092/api/authors/1
    public Author updateAuthor(Long authorId, Author authorObject) {
        LOGGER.info("service calling updateAuthor method ==> ");
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            if (authorObject.getLastName().equals(author.get().getLastName())) {
                throw new InformationExistException("author with name " + author.get().getLastName() + " already exist");
            } else {
                Author updateAuthor = authorRepository.findById(authorId).get();
                updateAuthor.setLastName(authorObject.getLastName());
                updateAuthor.setFirstName(authorObject.getFirstName());
                updateAuthor.setBook(authorObject.getBook());
                return authorRepository.save(updateAuthor);
            }
        } else {
            throw new InformationNotFoundException("author with id " + authorId + " not found");
        }

    }

    //Delete a author http://localhost:9092/api/author/1
    public Optional<Author> deleteAuthor(Long authorId) {
        LOGGER.info("calling deleteAuthor method ==>");
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            authorRepository.deleteById(authorId);
            return author;
        } else {
            throw new InformationNotFoundException("author with id: " + authorId + " not found");
        }
    }

    // get author by book  /author/{authorId}books
    public List<Author> getAuthorBooks(Long authorId) {
        LOGGER.info("service calling getAuthorBooks ==>");
        Optional<Book> book = bookRepository.findById(authorId);
        if (book.isPresent()) {
            return book.get().getAuthorList();
        } else {
            throw new InformationNotFoundException("author with id " + authorId + " not found");
        }
    }
//    public Author getAuthorBook(Long authorId, Long bookId) {
//        LOGGER.info("service calling getAuthorBook ==>");
//        Optional<Author> author = authorRepository.findById(authorId);
//        if (author.isPresent()) {
//            Optional<Book> book = bookRepository.findById(bookId).stream().filter(
//                    p -> p.getId().equals(bookId)).findFirst();
//            if (book.isEmpty()) {
//                throw new InformationNotFoundException("book with id " + bookId + " not found");
//            } else {
//                return author.get();
//            }
//        } else {
//            throw new InformationNotFoundException("author with id " + authorId + " not found");
//        }
//    }

    // get author by genre  /author/{authorId}genres
    public List<Author> getAuthorGenres(Long authorId) {
        LOGGER.info("service calling getAuthorGenres ==>");
        Optional<Genre> genre = genreRepository.findById(authorId);
        if (genre.isPresent()) {
            return genre.get().getBook().getAuthorList();
        } else {
            throw new InformationNotFoundException("author with id " + authorId + " not found");
        }
    }

    // get author by Publisher /author/{authorId}publishers
    public List<Author> getAuthorPublishers(Long authorId) {
        LOGGER.info("service calling getAuthorPublishers ==>");
        Optional<Publisher> publisher = publisherRepository.findById(authorId);
        if (publisher.isPresent()) {
            return publisher.get().getBook().getAuthorList();
        } else {
            throw new InformationNotFoundException("author with id " + authorId + " not found");
        }
    }


    // ===============================================Genre=========================================================
// get all Genres http://localhost:9092/api/genres/
    public List<Genre> getGenres() {
        LOGGER.info("service calling getGenre==>");
        return genreRepository.findAll();
    }

    // get a single genre http://localhost:9092/api/genres/1
    public Optional getGenre(Long genreId) {
        LOGGER.info("service calling getGenre==>");
        Optional genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            return genre;
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }
    }

    // create a single genre http://localhost:9092/api/books/1/genres
    public Genre createGenre(Long bookId, Genre genreObject) {
        LOGGER.info("service calling createGenre ==>");
        try{
            Optional book = bookRepository.findById(bookId);
            genreObject.setBook((Book) book.get());
            return genreRepository.save(genreObject);
        }catch (NoSuchElementException e){
            throw new InformationNotFoundException("book with id " + bookId + " not found");
        }
    }

    // UPDATE a genre http://localhost:9092/api/genres/1
    public Genre updateGenre(Long genreId, Genre genreObject) {
        LOGGER.info("service calling updateGenre method ==> ");
        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            if (genreObject.getName().equals(genre.get().getName())) {
                throw new InformationExistException("genre with name " + genre.get().getName() + " already exist");
            } else {
                Genre updateGenre = genreRepository.findById(genreId).get();
                updateGenre.setName(genreObject.getName());
                updateGenre.setSubGenre(genreObject.getSubGenre());
                updateGenre.setBook(genreObject.getBook());
                return genreRepository.save(updateGenre);
            }
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }

    }

    //Delete a genre http://localhost:9092/api/genres/1
    public Optional<Genre> deleteGenre(Long genreId) {
        LOGGER.info("calling deleteGenre method ==>");
        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            genreRepository.deleteById(genreId);
            return genre;
        } else {
            throw new InformationNotFoundException("genre with id: " + genreId + " not found");
        }
    }


    // ===============================================Publisher=========================================================
// get all publishers http://localhost:9092/api/publishers/
    public List<Publisher> getPublishers() {
        LOGGER.info("service calling getPublisher ==>");
        return publisherRepository.findAll();
    }

    // get a single publisher http://localhost:9092/api/publishers/1
    public Optional getPublisher(Long publisherId) {
        LOGGER.info("service calling getPublisher ==>");
        Optional publisher = publisherRepository.findById(publisherId);
        if (publisher.isPresent()) {
            return publisher;
        } else {
            throw new InformationNotFoundException("publisher with id " + publisherId + " not found");
        }
    }

    // create a single publisher http://localhost:9092/api/books/1/publishers/
    public Publisher createPublisher(Long bookId, Publisher publisherObject) {
        LOGGER.info("service calling createPublisher ==>");
        try {
            Optional book = bookRepository.findById(bookId);
            publisherObject.setBook((Book) book.get());
            return publisherRepository.save(publisherObject);
        }catch (NoSuchElementException e){
            throw new InformationNotFoundException("book with id " + bookId + " not found");
        }
//        Publisher publisher = publisherRepository.findByPublisherName(publisherObject.getPublisherName());

    }


    //UPDATE a publisher http://localhost:9092/api/publishers/1
    public Publisher updatePublisher(Long publisherId, Publisher publisherObject) {
        LOGGER.info("service calling updatePublisher method ==> ");
        Optional<Publisher> publisher = publisherRepository.findById(publisherId);
        if (publisher.isPresent()) {
            if (publisherObject.getPublisherName().equals(publisher.get().getPublisherName())) {
                throw new InformationExistException("publisher with name " + publisher.get().getPublisherName() + " already exist");
            } else {
                Publisher updatePublisher = publisherRepository.findById(publisherId).get();
                updatePublisher.setPublisherName(publisherObject.getPublisherName());
                updatePublisher.setBook(publisherObject.getBook());
                return publisherRepository.save(updatePublisher);
            }
        } else {
            throw new InformationNotFoundException("publisher with id " + publisherId + " not found");
        }

    }

    //Delete a publisher  http://localhost:9092/api/publishers/1
    public Optional<Publisher> deletePublisher(Long publisherId) {
        LOGGER.info("calling deletePublisher method ==>");
        Optional<Publisher> publisher = publisherRepository.findById(publisherId);
        if (publisher.isPresent()) {
            publisherRepository.deleteById(publisherId);
            return publisher;
        } else {
            throw new InformationNotFoundException("publisher with id: " + publisherId + " not found");
        }
    }

}
//get all book by authors
//    public List<Author> getBookAuthors(Long bookId) {
//        LOGGER.info("service calling getBookAuthors ==>");
//        Optional<Book> book = bookRepository.findById(bookId);
//        if (book.isPresent()) {
//            return book.get().getAuthorList();
//        } else {
//            throw new InformationNotFoundException("book with id " + bookId + " not found");
//        }