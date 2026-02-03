package com.example.ptudj2ee_bai3.service;

import com.example.ptudj2ee_bai3.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private Long nextId = 1L;
    public List<Book> getAllBooks(){
        return books;
    }
    public void addBook(Book book){
        book.setId(nextId++);
        books.add(book);
    }
    public Optional<Book> getBookById(Long id){
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }
    public void updateBook(Long id, Book updatedBook){
        books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .ifPresent(existingBook -> {
                    existingBook.setTitle(updatedBook.getTitle());
                    existingBook.setAuthor(updatedBook.getAuthor());
                });
    }
    public void deleteBook(Long id){
        books.removeIf(book -> book.getId().equals(id));
    }
    @PostConstruct
    public void initData() {
        books.add(new Book(nextId++, "Sách 1", "Tác giả 1"));
        books.add(new Book(nextId++, "Sách 2", "Tác giả 2"));
        books.add(new Book(nextId++, "Sách 3", "Tác giả 3"));
    }
}
