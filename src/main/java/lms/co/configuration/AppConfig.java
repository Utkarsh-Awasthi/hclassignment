package lms.co.configuration;

import lms.co.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lms.co.repository.BookRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Configuration
public class AppConfig {
    @Bean
    public BookRepository booksRepo(){
        return new BookRepository() {
            @Override
            public String getBook(int id) {
                return null;
            }

            @Override
            public List<Book> findAll() {
                return null;
            }

            @Override
            public List<Book> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<Book> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public List<Book> findAllById(Iterable<Integer> integers) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(Book book) {

            }

            @Override
            public void deleteAll(Iterable<? extends Book> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Book> S save(S s) {
                return null;
            }

            @Override
            public <S extends Book> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Book> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Book> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<Book> entities) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Book getOne(Integer integer) {
                return null;
            }

            @Override
            public <S extends Book> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Book> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Book> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public <S extends Book> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Book> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Book> boolean exists(Example<S> example) {
                return false;
            }

        };
    }

}

