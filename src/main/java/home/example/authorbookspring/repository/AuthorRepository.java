package home.example.authorbookspring.repository;

import home.example.authorbookspring.model.Author;
import home.example.authorbookspring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

    List<Author> findAllByName(String name);

}
