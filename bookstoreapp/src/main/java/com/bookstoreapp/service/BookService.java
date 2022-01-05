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

// Create a new book object
    public Book createBook(Book bookObject) {
        LOGGER.info("service calling createBook ==>");
// throws error if book exist
        Book book = bookRepository.findByTitle(bookObject.getTitle());
        if (book != null) {
            throw new InformationExistException("book with name " + book.getTitle() + " already exists");
        } else {
            System.out.println(bookObject.getPublisherList());
            return bookRepository.save(bookObject);
        }
    }

// Delete a book
    public Book deleteBook(Long bookId) {
        LOGGER.info("calling deleteBook method ==>");

        Optional<Book> book = bookRepository.findById(bookId);
        if (book != null) {
            bookRepository.deleteById(bookId);
            return book.get();
        } else {
            throw new InformationNotFoundException("category with id: " + bookId + " does NOT exists");
        }
    }

// view all authors
    public List<Author> getAuthor() {
        LOGGER.info("service calling getAuthor ==>");
        return authorRepository.findAll();
    }

// create an author
    public Author createAuthor(Author authorObject) {
        LOGGER.info("service calling createAuthor ==>");
        Author author = authorRepository.findByLastName(authorObject.getLastName());
        if (author != null) {
            throw new InformationExistException("Author with name "
                    + author.getLastName() + " already exists");
        } else {
            return authorRepository.save(authorObject);
        }
    }
// view an Author by author id
    public Optional getAuthor(Long authorId) {
        LOGGER.info("service calling getAuthor ==>");
        Optional author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            return author;
        } else {
            throw new InformationNotFoundException("Author with id " + authorId + "not found");
        }
    }
// view by book id
    public List<Author> getBookAuthor(Long bookId) {
        LOGGER.info("service calling getBookAuthors ==>");
        List<Author> author = authorRepository.findByBookId(bookId);
        if (author.isEmpty()) {
            throw new InformationNotFoundException("Cannot retrieve authors for book with id "
                    + bookId + "that does not exist");
        } else {
            return author;
        }
    }
 //view all publisher if none exist throw error
//    public List<Author> getAuthorFromPublisher(Long publisherId) {
//        LOGGER.info("service calling authors that belongs to a publisher ==>");
//        List<Author> author = authorRepository.findBypublisherId(publisherId);
//        if (author.isEmpty()) {
//            throw new InformationNotFoundException("Cannot retrieve authors for a publisher with id "
//                    + publisherId + "that does not exist");
//        } else {
//            return author;
//        }
//    }

// update author by id
    public Author updateAuthor(Long authorId, Author authorObject) {
        LOGGER.info("service calling updateAuthor ==>");
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isPresent()) {

            Author updateAuthor = authorRepository.findById(authorId).get();
            updateAuthor.setLastName(authorObject.getLastName());
            return authorRepository.save(updateAuthor);

        } else {
            throw new InformationNotFoundException("author with id " + authorId + " not found");
        }
    }

// delete author by id
    public Optional<Author> deleteAuthor(Long authorId) {
        LOGGER.info("service calling updateAuthor ==>");
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            authorRepository.deleteById(authorId);
            return author;
        } else {
            throw new InformationNotFoundException("Author with id " + authorId + " not found");
        }
    }

// find all genre
    public List<Genre> getGenre() {
        LOGGER.info("service calling getGenre ==>");

        List<Genre> genre = genreRepository.findAll();
        if (genre.isEmpty()) {
            throw new InformationNotFoundException("no categories found");
        } else {
            return genre;
        }
    }
// create genre
    public Genre createGenre(Genre genreObject) {
        LOGGER.info("service calling createGenre ==>");

        Genre genre = genreRepository.findByName(genreObject.getName());
        if (genre != null) {
            throw new InformationExistException("category with name " + genre.getName() + " already exists");
        } else {
            return genreRepository.save(genreObject);
        }
    }
// view genre by id

    public Optional getGenre(Long genreId) {
        LOGGER.info("service calling getGenre ==>");
        Optional genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            return genre;
        } else {
            throw new InformationNotFoundException("Genre with id " + genreId + "not found");
        }
    }
// update genre by id
    public Genre updateGenre(Long genreID, Genre genreObject) {
        LOGGER.info("calling updateGenre method ==> ");

        Optional<Genre> genre = genreRepository.findById(genreID);
        if (genre == null) {
            throw new InformationNotFoundException("category with id " + genreID + " not found");
        } else {
            genre.get().setName(genreObject.getName());
            return genreRepository.save(genre.get());
        }
    }

// delete genre by id
    public Genre deleteGenre(Long genreId) {
        LOGGER.info("calling deleteCategory method ==>");

        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre != null) {
            genreRepository.deleteById(genreId);
            return genre.get();
        } else {
            throw new InformationNotFoundException("category with id: " + genreId + " does NOT exists");
        }
    }

// view publisher if exist
    public List<Publisher> getPublisher() {
        LOGGER.info("service calling getPublishers ==>");

        List<Publisher> publisher = publisherRepository.findAll();
        if (publisher.isEmpty()) {
            throw new InformationNotFoundException("no publishers found");
        } else {
            return publisher;
        }
    }
// create publisher
    public Publisher createPublisher(Publisher publisherObject) {
        LOGGER.info("service calling createPublisher ==>");

        Publisher publisher = publisherRepository.findByPublisherName(publisherObject.getPublisherName());
        if (publisher != null) {
            throw new InformationExistException("publisher with name " + publisher.getPublisherName() + " already exists");
        } else {
            return publisherRepository.save(publisherObject);
        }
    }

// view publisher
    public Optional getPublisher(Long publisherId) {
        LOGGER.info("service calling getPublisher ==>");
        Optional publisher = publisherRepository.findById(publisherId);
        if (publisher.isPresent()) {
            return publisher;
        } else {
            throw new InformationNotFoundException("Publisher with id " + publisherId + "not found");
        }
    }
// update publisher

    public Publisher updatePublisher(Long publisherId, Publisher publisherObject) {
        LOGGER.info("calling updatePublisher method ==> ");

        Optional<Publisher> publisher = publisherRepository.findById(publisherId);
        if (publisher == null) {
            throw new InformationNotFoundException("publisher with id " + publisherId + " not found");
        } else {
            publisher.get().setPublisherName(publisherObject.getPublisherName());
            return publisherRepository.save(publisher.get());
        }
    }

// delete publisher
    public Publisher deletePublisher(Long publisherId) {
        LOGGER.info("calling deletePublisher method ==>");

        Optional<Publisher> publisher = publisherRepository.findById(publisherId);

        if (publisher != null) {
            publisherRepository.deleteById(publisherId);
            return publisher.get();
        } else {
            throw new InformationNotFoundException("publisher with id: " + publisherId + " does NOT exists");
        }
    }


}