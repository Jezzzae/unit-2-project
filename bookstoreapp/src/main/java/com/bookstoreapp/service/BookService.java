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
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class BookService {
    private static final Logger LOGGER = Logger.getLogger(BookController.class.getName());


    private static BookRepository bookRepository;


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

    //1 -> GET all books  http://localhost:9092/api/books/
    public List<Book> getBooks() {
        LOGGER.info("service calling getBook==>");
        return bookRepository.findAll();
    }

    //2 -> Get one book http://localhost:9092/api/books/1
    public Optional getBook(Long bookId) {
        System.out.println("service calling getBook==>");
        Optional book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            return book;
        } else {
            throw new InformationNotFoundException("book with id " + bookId + " not found");
        }
    }

    //3 -> CREATE a book  http://localhost:9092/api/books/
    public Book createBook(Book bookObject) {
        System.out.println("service calling createBook ==>");
        Book book = bookRepository.findByTitle(bookObject.getTitle());
        if (book != null) {
            throw new InformationNotFoundException("book with name " + book.getTitle() + " already exists");
        } else {

            return bookRepository.save(bookObject);
        }
    }

    //4 - > UPDATE a book  http://localhost:9092/api/books/1
    public Book updateBook(Long bookId, Book bookObject) {
        System.out.println("service calling updateBook method ==> ");
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            if (bookObject.getTitle().equals(book.get().getTitle())) {
                throw new InformationExistException("book with id " + book.get().getTitle() + " already exist");
            } else {
                Book updateBook = bookRepository.findById(bookId).get();
                updateBook.setTitle(bookObject.getTitle());
                updateBook.setAuthorList(bookObject.getAuthorList());
                updateBook.setGenreList(bookObject.getGenreList());
                updateBook.setPublisherList(bookObject.getPublisherList());
                return bookRepository.save(updateBook);
            }
        } else {
            throw new InformationNotFoundException("book with id " + bookId + " not found");
        }

    }

    //5 - > DELETE a book  http://localhost:9092/api/books/1
    public Optional<Book> deleteBook(Long bookId) {
        System.out.println("calling deleteBook method ==>");
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            bookRepository.deleteById(bookId);
            return book;
        } else {
            throw new InformationNotFoundException("book with id: " + bookId + " not found");
        }
    }
}