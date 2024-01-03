package com.robp.databaseWithJDBC.dao;

import com.robp.databaseWithJDBC.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    //Optional per gestire il caso in cui Author è assente evitando NullPointer
    Optional<Author> findOne(long id);

    List<Author> find();

    void update(Author author, long id);

    void delete(long id);
}
