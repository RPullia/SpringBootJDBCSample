package com.robp.databaseWithJDBC.dao.impl;

import com.robp.databaseWithJDBC.TestDataUtil;
import com.robp.databaseWithJDBC.domain.Author;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) //Evita test pollution dovuta alla creazione multipla ad esempio degli author
public class AuthorDaoImplIntegrationTest {

    private AuthorDaoImpl underTest;

    // Autowired segnala a Spring la necessità di fare injection dei parametri forniti al costruttore
    @Autowired
    public AuthorDaoImplIntegrationTest(AuthorDaoImpl underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecorded(){
        Author author = TestDataUtil.createTestAuthorA();
        underTest.create(author);
        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatMultipleAuthorCanBeCreatedAndRecorded(){
        Author authorA = TestDataUtil.createTestAuthorA();
        underTest.create(authorA);

        Author authorB = TestDataUtil.createTestAuthorB();
        underTest.create(authorB);

        List<Author> results = underTest.find();
        assertThat(results).hasSize(2);
        assertThat(results).containsExactly(authorA, authorB);


    }

    @Test
    public void testThatAuthorCanBeUpdated(){
        Author author  = TestDataUtil.createTestAuthorA();
        underTest.create(author);
        author.setName("Tizio");

        underTest.update(author, author.getId());
        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);


    }

    @Test
    public void testThatAuthorCanBeDeleted(){
        Author authorA = TestDataUtil.createTestAuthorA();
        underTest.create(authorA);
        underTest.delete(authorA.getId());
        Optional<Author> result = underTest.findOne(authorA.getId());
        assertThat(result).isEmpty();
    }


}
