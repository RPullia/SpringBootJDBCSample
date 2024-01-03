package com.robp.databaseWithJDBC;

import com.robp.databaseWithJDBC.domain.Author;
import com.robp.databaseWithJDBC.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){

    }

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Mario Rossi")
                .age(40)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("1235-56-6642-122")
                .title("Il signore degli anelli")
                .authorId(1L)
                .build();
    }
}
