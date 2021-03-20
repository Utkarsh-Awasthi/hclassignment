package lms.co.service;

import lms.co.exceptions.BookNotFoundException;
import lms.co.model.Book;
import lms.co.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService implements BookServiceInterface {

    @Autowired
    private BookRepository BookRepo;

    @Override
    public List<Book> getAllBookList() {
        return BookRepo.findAll();
    }
    @Override
    public String getBookbyid(int id) throws BookNotFoundException {
        return BookRepo.getBook(id);
    }


}
