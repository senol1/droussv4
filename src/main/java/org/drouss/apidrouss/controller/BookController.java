package org.drouss.apidrouss.controller;

import org.drouss.apidrouss.dao.BookDao;
import org.drouss.apidrouss.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/books", method=RequestMethod.GET)
    public MappingJacksonValue getBooks() {
        Iterable<Book> books = bookDao.findAll();
        return (MappingJacksonValue) books;
    }

    /*@GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id) {
        return bookDao.findById(id);
    }

    @PostMapping("/books")
    public ResponseEntity<Void> saveBook(@RequestBody Book book) {
        Book bookadded = bookDao.save(book);

        if(bookadded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bookadded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }*/
}
