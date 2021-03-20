package lms.co.repository;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lms.co.model.Book;
import org.springframework.stereotype.Repository;

@Repository
@Cacheable
//@Cache(region = "BookCache")
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT name FROM Books WHERE id = :id")
    public String getBook(@Param("id") int id);


}
