package com.github.torento2.bookcatalog.repository;
import com.github.torento2.bookcatalog.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {


}
