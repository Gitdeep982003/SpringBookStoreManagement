package com.example.BookStoreManagement.Service;

import com.example.BookStoreManagement.Entity.Book;
import com.example.BookStoreManagement.Repository.BookRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRep bookRep;

    public Book addBook(Book book)
    {
       Book b = bookRep.save(book);
       return b;
    }

    public List<Book> getAllBooks()
    {
        List<Book> bs = bookRep.findAll();
        return bs;
    }
    public Book getBookById(int id)
    {
        Book bks = bookRep.findById(id).get();
        return bks;
    }

    public Book updateBook(int id,Book book)
    {

        Book boo = bookRep.findById(id).get();
        boo.setBookName(book.getBookName());
        boo.setBookAuthor(book.getBookAuthor());
        boo.setBookPrice(book.getBookPrice());
        bookRep.save(boo);
        return boo;
    }
    // Method to find books by title and author
   public Book getBookBYBookNameAndBookAuthor(String bookName,String bookAuthor)
   {
       return bookRep.findByBookNameAndBookAuthor(bookName,bookAuthor).get();
   }

    public String deleteBook(int id)
    {
        Book bk = bookRep.findById(id).get();
       bookRep.delete(bk);
       return "Book Deleted Successfully";
    }
    public String deleteAll()
    {
         bookRep.deleteAll();
        return "All books are deleted";
    }

}
