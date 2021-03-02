package home.example.authorbookspring.repository;


import home.example.authorbookspring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BookRepository extends JpaRepository<Book,Integer> {



}
