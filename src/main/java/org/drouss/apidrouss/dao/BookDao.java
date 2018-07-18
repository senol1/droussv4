package org.drouss.apidrouss.dao;

import org.drouss.apidrouss.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {

}
