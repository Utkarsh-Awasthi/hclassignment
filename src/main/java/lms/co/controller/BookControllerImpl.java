package lms.co.controller;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import lms.co.exceptions.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lms.co.model.Book;
import lms.co.repository.BookRepository;

@RestController
@RequestMapping("/api")
@Api(value = "Book", description = "Operations about Books")
public class BookControllerImpl {

    @Autowired
    private BookRepository booksRepo;



    @ApiOperation(value = "gets a list of all books", notes = "ArrayList <Book>.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error--", response = Response.class),
    })
    @GetMapping(value = "/books")
    public ResponseEntity<GenericResponse<Object>> getAllBooks() {
            return new ResponseEntity<>(
                    new GenericResponse<>(true,
                            HttpStatus.OK.name(),
                          booksRepo.findAll()),
                    HttpStatus.OK
            );
        }

    @ApiOperation(value = "gets a specified book by id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class),
    })
    @GetMapping(value = "/books/{id}")
    ResponseEntity<GenericResponse<Object>> getBookbyid(@PathVariable("id") int id) {
        return new ResponseEntity<>(
                new GenericResponse<>(true,
                        HttpStatus.OK.name(),
                        booksRepo.getBook(id)),
                HttpStatus.OK
        );
    }


    @ApiOperation(value = "gets a specified book by name")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class),
    })
    @PostMapping(value = "search/book/{name}")
    public ResponseEntity<List<Book>> getBooksByTitleAuthor(@PathVariable String name) {
        Book booksearch =  new Book();
        List<Book> search = new ArrayList<>();
        HttpStatus httpStatus;
        
        List<Book> books = booksRepo.findAll();
    	
        books.forEach(book -> {
       	 if(book.getTitle().equals(name) || book.getAuthor().equals(name))
    		{
		 
    			booksearch.setTitle(book.getTitle());
    			booksearch.setAuthor(book.getAuthor());
    			booksearch.setBorrowDate(book.getBorrowDate()); 
    			booksearch.setBorrower(book.getBorrower());
    			booksearch.setPublisher(book.getPublisher());
    			booksearch.setid(book.getid());
    			booksearch.setReturnDate(book.getReturnDate());
    			booksearch.setStatus(book.getStatus());
    			booksearch.setid(book.getid());
    			search.add(book);
    		}
       	 
	 
       });
        
        if(search.size() > 0){
        	    httpStatus = HttpStatus.OK;
            //booksearch.add(linkTo(methodOn(UsersResourceImpl.class).getAllUsers()).withRel("Users"));
        } else {
            httpStatus = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(search, httpStatus);

    }

}
