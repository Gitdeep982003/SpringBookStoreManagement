package com.example.BookStoreManagement.Repository;

import com.example.BookStoreManagement.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRep extends JpaRepository<Book,Integer> {

    Optional<Book> findByBookNameAndBookAuthor(String bookName,String bookAuthor);

}
