package lms.co.service;

import lms.co.exceptions.BookNotFoundException;
import lms.co.model.Book;

import java.util.List;

public interface BookServiceInterface {
    List<Book> getAllBookList();

    String getBookbyid(int id) throws BookNotFoundException;
}
