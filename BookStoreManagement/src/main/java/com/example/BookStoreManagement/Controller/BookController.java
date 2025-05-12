package com.example.BookStoreManagement.Controller;

import com.example.BookStoreManagement.Entity.Book;
import com.example.BookStoreManagement.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book)
    {
        return bookService.addBook(book);
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }
    @GetMapping("/GetOneId/{id}")
    public Book getBookById(@PathVariable int id)
    {
        return bookService.getBookById(id);
    }
    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable int id,@RequestBody Book book)
    {
        return bookService.updateBook(id, book);
    }
    @GetMapping("/getBookBYBookNameAndBookAuthor")
   public  Book getBookBYBookNameAndBookAuthor(@RequestParam String bookName,@RequestParam String bookAuthor)
   {
       return bookService.getBookBYBookNameAndBookAuthor(bookName,bookAuthor);
   }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id)
    {
        return bookService.deleteBook(id);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll()
    {
      return   bookService.deleteAll();
    }

}
