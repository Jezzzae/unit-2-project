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



@Service
public class BookService {


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
        System.out.println("service calling getBook==>");
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
            throw new InformationExistException("book with name " + book.getTitle() + " already exists");
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

    // ===============================================AUTHOR=========================================================
// get all authors http://localhost:9092/api/authors/
    public List<Author> getAuthors() {
        System.out.println("service calling getBook==>");
        return authorRepository.findAll();
    }

    // get a single author http://localhost:9092/api/authors/1
    public Optional getAuthor(Long authorId) {
        System.out.println("service calling getAuthor==>");
        Optional author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            return author;
        } else {
            throw new InformationNotFoundException("author with id " + authorId + " not found");
        }
    }

    // create a single author http://localhost:9092/api/authors/
    public Author createAuthor(Author authorObject) {
        System.out.println("service calling createAuthor ==>");
        Author author = authorRepository.findByLastName(authorObject.getLastName());

        if (author != null) {
            throw new InformationExistException("author with name " + author.getLastName() + " already exists");

        } else {

            return authorRepository.save(authorObject);
        }

    }

    public Author updateAuthor(Long authorId, Author authorObject) {
        System.out.println("service calling updateAuthor method ==> ");
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            if (authorObject.getLastName().equals(author.get().getLastName())) {
                throw new InformationExistException("author with id " + author.get().getLastName() + " already exist");
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

    //Delete a book  http://localhost:9092/api/author/1
    public Optional<Author> deleteAuthor(Long authorId) {
        System.out.println("calling deleteAuthor method ==>");
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            authorRepository.deleteById(authorId);
            return author;
        } else {
            throw new InformationNotFoundException("author with id: " + authorId + " not found");
        }
    }




// ===============================================Genre=========================================================
// get all authors http://localhost:9092/api/genres/
    public List<Genre> getGenres() {
        System.out.println("service calling getGenre==>");
        return genreRepository.findAll();
    }

    // get a single author http://localhost:9092/api/genres/1
    public Optional getGenre(Long genreId) {
        System.out.println("service calling getGenre==>");
        Optional genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            return genre;
        } else {
            throw new InformationNotFoundException("genre with id " + genreId + " not found");
        }
    }

    // create a single author http://localhost:9092/api/genres/
    public Genre createGenre(Genre genreObject) {
        System.out.println("service calling createGenre ==>");
        Genre genre = genreRepository.findByName(genreObject.getName());

        if (genre != null) {
            throw new InformationExistException("genre with name " + genre.getName() + " already exists");

        } else {

            return genreRepository.save(genreObject);
        }

    }

    public Genre updateGenre(Long genreId, Genre genreObject) {
        System.out.println("service calling updateGenre method ==> ");
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

    //Delete a book  http://localhost:9092/api/genre/1
    public Optional<Genre> deleteGenre(Long genreId) {
        System.out.println("calling deleteGenre method ==>");
        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
           genreRepository.deleteById(genreId);
            return genre;
        } else {
            throw new InformationNotFoundException("genre with id: " + genreId + " not found");
        }
    }


// ===============================================Publisher=========================================================
// get all authors http://localhost:9092/api/authors/
//public List<Author> getAuthors() {
//    System.out.println("service calling getBook==>");
//    return authorRepository.findAll();
//}
//
//    // get a single author http://localhost:9092/api/authors/1
//    public Optional getAuthor(Long authorId) {
//        System.out.println("service calling getAuthor==>");
//        Optional author = authorRepository.findById(authorId);
//        if (author.isPresent()) {
//            return author;
//        } else {
//            throw new InformationNotFoundException("author with id " + authorId + " not found");
//        }
//    }
//
//    // create a single author http://localhost:9092/api/authors/
//    public Author createAuthor(Author authorObject) {
//        System.out.println("service calling createAuthor ==>");
//        Author author = authorRepository.findByLastName(authorObject.getLastName());
//
//        if (author != null) {
//            throw new InformationExistException("author with name " + author.getLastName() + " already exists");
//
//        } else {
//
//            return authorRepository.save(authorObject);
//        }
//
//    }
//
//    public Author updateAuthor(Long authorId, Author authorObject) {
//        System.out.println("service calling updateAuthor method ==> ");
//        Optional<Author> author = authorRepository.findById(authorId);
//        if (author.isPresent()) {
//            if (authorObject.getLastName().equals(author.get().getLastName())) {
//                throw new InformationExistException("author with id " + author.get().getLastName() + " already exist");
//            } else {
//                Author updateAuthor = authorRepository.findById(authorId).get();
//                updateAuthor.setLastName(authorObject.getLastName());
//                updateAuthor.setFirstName(authorObject.getFirstName());
//                updateAuthor.setBook(authorObject.getBook());
//                return authorRepository.save(updateAuthor);
//            }
//        } else {
//            throw new InformationNotFoundException("author with id " + authorId + " not found");
//        }
//
//    }
//
//    //Delete a book  http://localhost:9092/api/author/1
//    public Optional<Author> deleteAuthor(Long authorId) {
//        System.out.println("calling deleteAuthor method ==>");
//        Optional<Author> author = authorRepository.findById(authorId);
//        if (author.isPresent()) {
//            authorRepository.deleteById(authorId);
//            return author;
//        } else {
//            throw new InformationNotFoundException("author with id: " + authorId + " not found");
//        }
//    }

}
//get all book by authors
//    public List<Author> getBookAuthors(Long bookId) {
//        System.out.println("service calling getBookAuthors ==>");
//        Optional<Book> book = bookRepository.findById(bookId);
//        if (book.isPresent()) {
//            return book.get().getAuthorList();
//        } else {
//            throw new InformationNotFoundException("book with id " + bookId + " not found");
//        }