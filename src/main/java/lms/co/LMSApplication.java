package lms.co;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import lms.co.repository.BookRepository;


@EnableAutoConfiguration
public class LMSApplication
{
    @Autowired
    private BookRepository booksRepo;


    public static void main( String[] args ){
        SpringApplication.run(LMSApplication.class, args);

    }

    @PostConstruct
    public void initApplication() throws IOException {
       // booksRepo.addBook(new Book("111-1","autobiography of a yogi","Yogananda","pbs publisher","Avilable","none","none","none"));

    }
}

